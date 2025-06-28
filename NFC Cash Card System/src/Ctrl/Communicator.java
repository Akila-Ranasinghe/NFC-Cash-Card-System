/*
 * Copyright (c) 2018 Spyder Innovations </Akila Ranasinghe>
 * All rights reserved.
 */
package Ctrl;

import Views.Customer_AccountDetails;
import Views.Customer_ChangeContact;
import Views.Customer_ChangePassword;
import Views.Customer_Confirm;
import Views.Customer_CreateAccount;
import Views.Home;
import Views.Seller_AccountDetails;
import Views.Seller_ChangePassword;
import Views.Seller_CreateAccount;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TooManyListenersException;

/**
 * @author AKILA
 */
public class Communicator implements SerialPortEventListener {

    //for containing the ports that will be found
    private Enumeration ports = null;
    //map the port names to CommPortIdentifiers
    private final HashMap portMap = new HashMap();

    //this is the object that contains the opened port
    private CommPortIdentifier selectedPortIdentifier = null;
    private SerialPort serialPort = null;

    //input and output streams for sending and receiving data
    private InputStream input = null;
    private OutputStream output = null;

    //just a boolean flag that i use for enabling
    //and disabling buttons depending on whether the program
    //is connected to a serial port or not
    private boolean bConnected = false;

    //the timeout value for connecting with the port
    final static int TIMEOUT = 2000;

    //some ascii values for for certain things
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;

    // temp_DataHolding VARIABLES
    private static String payerUserObject_nfcID;

    //search for all the serial ports
    //pre: none
    //post: return the found ports to  GUI req. method
    public String searchForPorts() {
        String portName = "";
        ports = CommPortIdentifier.getPortIdentifiers();

        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();

            //get only serial ports
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                portName = curPort.getName();
                portMap.put(curPort.getName(), curPort);
            }
        }
        return portName;
    }

    //connect to the passing param port from GUI method
    //pre: ports are already found by using the searchForPorts method
    //post: the connected comm port is stored in commPort, otherwise,
    //an exception is generated
    public void connect(String portName) {

        String selectedPort = portName;
        selectedPortIdentifier = (CommPortIdentifier) portMap.get(selectedPort);

        CommPort commPort = null;

        try {
            //the method below returns an object of type CommPort
            commPort = selectedPortIdentifier.open("CCS", TIMEOUT);
            //the CommPort object can be casted to a SerialPort object
            serialPort = (SerialPort) commPort;

            //for controlling GUI elements
            setConnected(true);

            //logging
            //enables the controls on the GUI if a successful connection is made
          //  System.out.println(selectedPort + " open successfully. --------------------------------------");

//            Home.lbl_deviceOn.setVisible(true);
        } catch (PortInUseException e) {
            Home.lbl_deviceOn.setVisible(false);
          //  System.out.println(selectedPort + "is in use. --------------------------------------");
            e.printStackTrace();
        } catch (Exception e) {
            Home.lbl_deviceOn.setVisible(false);
          //  System.out.println("Faild to open --------------------------------------");
            e.printStackTrace();
        }
    }

    //open the input and output streams
    //pre: an open port
    //post: initialized intput and output streams for use to communicate data
    public boolean initIOStream() {
        //return value for whather opening the streams is successful or not
        boolean successful = false;

        try {
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            writeData("");

            successful = true;
            return successful;
        } catch (IOException e) {
            Home.lbl_deviceOn.setVisible(false);
          //  System.out.println("I/O Streams failed to open. --------------------------------------");
            e.printStackTrace();
            return successful;
        }
    }

    //starts the event listener that knows whenever data is available to be read
    //pre: an open serial port
    //post: an event listener for the serial port that knows when data is recieved
    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

        } catch (TooManyListenersException e) {
            Home.lbl_deviceOn.setVisible(false);
           // System.out.println("Too many listeners --------------------------------------");
            e.printStackTrace();
        }
    }

    //disconnect the serial port
    //pre: an open serial port
    //post: clsoed serial port
    public void disconnect() {
        //close the serial port
        try {
            writeData("");

            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            setConnected(false);
            Home.lbl_deviceOn.setVisible(false);
          //  System.out.println("Disconnected! --------------------------------------");

        } catch (Exception e) {
            Home.lbl_deviceOn.setVisible(false);
          //  System.out.println("Failed to close" + serialPort.getName() + "--------------------------------------");
            e.printStackTrace();
        }
    }

    final public boolean getConnected() {
        return bConnected;
    }

    public void setConnected(boolean bConnected) {
        this.bConnected = bConnected;
    }

    //what happens when data is received
    //pre: serial event is triggered
    //post: processing on the data it reads
    String inputText;

    @Override
    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {

                Home.lbl_deviceOn.setVisible(true);

                // collect receiving Data....
                Scanner scnn = new Scanner(serialPort.getInputStream());
                String scnnResult = scnn.nextLine();
                inputText = scnnResult;

               // System.out.println("INPUT:" + inputText);

                // THE UNDERGROUND PROCESSING FUNCTIONs .................................................................................................................................................................
                String splitValMAIN[];

                // Customer Confirmation Dialog Process  -- pass NFC Card data + NumPad inputs 2 GUIs  
                if (!Home.subWindowName.toString().isEmpty()) {
                  //  System.out.println("xxxxxxxxxxxxxxxxxxxx CnfDiag_Found: " + Home.subWindowName);

                    if (inputText.toString().contains("MAIN")) { // Filter incomming data --- [  data from Main Device ]
                        // ====== CUSTOMER's INTERFACES=======================================================================
                        // Window -- Customer_CreateNewAccount
                        if (Home.subWindowName.equals("CreateNewAccount")) {
                            if (inputText.toString().contains("MAIN_CARD_")) {
                                splitValMAIN = inputText.split("MAIN_CARD_");
                                Customer_CreateAccount.txt_nfcID.setText(splitValMAIN[1]);
                                Customer_CreateAccount.txt_firstName.grabFocus();
                                Home.communicator.writeData("MAIN_NEWREG-CARDOK");

                            } else if (inputText.toString().contains("MAIN_PSW_")) {
                                splitValMAIN = inputText.split("MAIN_PSW_");
                                Customer_CreateAccount.txt_password.setText(splitValMAIN[1]);
                                Customer_CreateAccount.btn_create.grabFocus();
                                Home.communicator.writeData("MAIN_NEWREG-PINOK");
                            }
                        }
                        // Window -- Customer_Confirmation [ Reload & Account Details ]
                        if (Home.subWindowName.equals("custConfirmation")) {
                            if (inputText.toString().contains("MAIN_CARD_")) {
                                splitValMAIN = inputText.split("MAIN_CARD_");
                                Customer_Confirm.txt_nfcID.setText(splitValMAIN[1]);
                                Customer_Confirm.btn_nfcLogin.doClick();

                            } else if (inputText.toString().contains("MAIN_PSW_")) {
                                splitValMAIN = inputText.split("MAIN_PSW_");
                                Customer_Confirm.txt_password.setText(splitValMAIN[1]);
                                Customer_Confirm.btn_login.doClick();
                            }
                        }
                        // Window -- Customer_AccountDetails > Password Confirmation Mini Dialog Frames
                        if (Home.subWindowName.equals("CustomerAccountDetails")) {
                            if (inputText.toString().contains("MAIN_PSW_")) {
                                splitValMAIN = inputText.split("MAIN_PSW_");
                                Customer_AccountDetails.pswField.setText(splitValMAIN[1]);
                            }
                        }
                        // Window -- Customer_AccountDetails >> Change Customer Password
                        if (Home.subWindowName.equals("CustomerAccountDetails_changePsw")) {
                            if (inputText.toString().contains("MAIN_PSW_")) {
                                if (Customer_ChangePassword.txt_PSWnew.getText().toString().trim().isEmpty()) {
                                    splitValMAIN = inputText.split("MAIN_PSW_");
                                    Customer_ChangePassword.txt_PSWnew.setText(splitValMAIN[1]);
                                } else if (Customer_ChangePassword.txt_PSWconfirm.getText().toString().trim().isEmpty()) {
                                    splitValMAIN = inputText.split("MAIN_PSW_");
                                    Customer_ChangePassword.txt_PSWconfirm.setText(splitValMAIN[1]);
                                    Customer_ChangePassword.btn_change.grabFocus();
                                }
                            }
                        }
                        // Window -- Customer_AccountDetails >> Change Customer Contact No
                        if (Home.subWindowName.equals("CustomerAccountDetails_changeCntNo")) {
                            if (inputText.toString().contains("MAIN_PSW_")) {
                                splitValMAIN = inputText.split("MAIN_PSW_");
                                Customer_ChangeContact.txt_contactNo.setText(splitValMAIN[1]);
                                Customer_ChangeContact.btn_change.grabFocus();
                            }
                        }

                        // ====== SELLER's INTERFACES=======================================================================
                        // Window -- Seller_CreateAccount
                        if (Home.subWindowName.equals("Seller_CreateAccount")) {
                            if (inputText.toString().contains("MAIN_PSW_")) {
                                splitValMAIN = inputText.split("MAIN_PSW_");
                                Seller_CreateAccount.txt_password.setText(splitValMAIN[1]);
                                Seller_CreateAccount.btn_create.grabFocus();
                            }
                        }
                        // Window -- Seller_AccountDetails > Password Confirmation Mini Dialog Frames
                        if (Home.subWindowName.equals("SellerAccountDetails")) {
                            if (inputText.toString().contains("MAIN_PSW_")) {
                                splitValMAIN = inputText.split("MAIN_PSW_");
                                Seller_AccountDetails.pswField.setText(splitValMAIN[1]);
                            }
                        }
                        // Window -- Seller_AccountDetails >> Change Seller Password
                        if (Home.subWindowName.equals("SellerAccountDetails_changePsw")) {
                            if (inputText.toString().contains("MAIN_PSW_")) {
                                if (Seller_ChangePassword.txt_PSWnew.getText().toString().trim().isEmpty()) {
                                    splitValMAIN = inputText.split("MAIN_PSW_");
                                    Seller_ChangePassword.txt_PSWnew.setText(splitValMAIN[1]);
                                } else if (Seller_ChangePassword.txt_PSWconfirm.getText().toString().trim().isEmpty()) {
                                    splitValMAIN = inputText.split("MAIN_PSW_");
                                    Seller_ChangePassword.txt_PSWconfirm.setText(splitValMAIN[1]);
                                    Seller_ChangePassword.btn_change.grabFocus();
                                }
                            }
                        }

                    }
                } else {
                    // Customer Payment Process ( pass NFC Card data + NumPad inputs 2 underground process )
                   // System.out.println("xxxxxxxxxxxxxxxxxxxx payment process.....");
                    if (inputText.toString().contains("SUB")) { // Filter incomming data --- [  data from  SUB Device ]

                        // [ 01 -get+check NFC input ID ]
                        if (inputText.toString().contains("SUB_CARD_")) {
                            splitValMAIN = inputText.split("SUB_CARD_");
                            ResultSet rsNFCidExist = JDBC.getData(" SELECT nfc_id FROM customer WHERE nfc_id = '" + splitValMAIN[1].toString() + "' ");
                            if (rsNFCidExist.next()) {
                                payerUserObject_nfcID = splitValMAIN[1].toString();
                                Home.communicator.writeData("NFCID_AVL");
                            } else {
                                payerUserObject_nfcID = null;
                                Home.communicator.writeData("NFCID_NA");
                            }
                        }

                        // [ 02 -get+check Password input  ]
                        if (inputText.toString().contains("SUB_PSW_")) {
                            splitValMAIN = inputText.split("SUB_PSW_");
                            ResultSet rsPSWExist = JDBC.getData(" SELECT nfc_id, password FROM customer WHERE nfc_id = '" + payerUserObject_nfcID + "' AND  password = '" + splitValMAIN[1].toString() + "'  ");
                            if (rsPSWExist.next()) {
                                Home.communicator.writeData("PSW_AVL");
                            } else {
                                Home.communicator.writeData("PSW_NA");
                            }
                        }

                        // [ 03 -get+check AMOUNT input  >> update Acc. Balances ]
                        if (inputText.toString().contains("SUB_AMT_")) {
                            splitValMAIN = inputText.split("SUB_AMT_");
                            ResultSet rsAMTCust = JDBC.getData(" SELECT customer_id, nfc_id, balance FROM customer WHERE nfc_id = '" + payerUserObject_nfcID + "'  ");
                            if (rsAMTCust.next()) {
                                double avlBalance = Double.valueOf(rsAMTCust.getString("balance"));
                                if (Double.valueOf(splitValMAIN[1].toString()) < avlBalance) {

                                    // update customer Acc.Balance
                                    JDBC.putData(" UPDATE customer SET balance = '" + Double.valueOf(avlBalance - Double.valueOf(splitValMAIN[1].toString())) + "' WHERE nfc_id = '" + payerUserObject_nfcID + "'  ");
                                    // update Sellers Acc.Balance
                                    ResultSet rPayeeblnc = JDBC.getData(" SELECT payee_account_id, balance FROM payee_account WHERE payee_account_id = '1'  ");
                                    if (rPayeeblnc.next()) {
                                        JDBC.putData(" UPDATE payee_account SET balance = '" + Double.valueOf(rPayeeblnc.getDouble("balance") + Double.valueOf(splitValMAIN[1].toString())) + "' WHERE payee_account_id = '1'  ");
                                    }
                                    // insert payment record
                                    JDBC.putData(" INSERT INTO payment VALUES( '0' ,'" + rsAMTCust.getString("customer_id") + "' , '1'  , '" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString() + "' , '" + new SimpleDateFormat("hh:mm:ss a").format(new Date()).toString() + "' , '" + Double.valueOf(splitValMAIN[1].toString()) + "'  ) ");

                                    Home.communicator.writeData("BALANCE_AVL");
                                } else {
                                    Home.communicator.writeData("BALANCE_NA");
                                }
                            }
                        }

                    } // ....end SUB....
                }
                // ../ end UG. process ............................................................................................................................................................................................................

                Home.lbl_deviceOn.setVisible(false);

            } catch (Exception e) {
                Home.lbl_deviceOn.setVisible(false);
              //  System.out.println("Failed to read data --------------------------------------");
                e.printStackTrace();
            }
        }
    }

    //method that can be called to send data
    //pre: open serial port
    //post: data sent to the other device
    public void writeData(String passData1) {
        try {

//            byte[] buffer = String.valueOf(passData1).getBytes();
//            output.write(buffer);
            //      
            output.write(passData1.getBytes());
            output.flush();

        } catch (Exception e) {
            Home.lbl_deviceOn.setVisible(false);
           // System.out.println("Failed to write data --------------------------------------");
            e.printStackTrace();
        }
    }

}
