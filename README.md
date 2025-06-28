# NFC-Cash-Card-System

**NFC Cash Card System** is a Java Swing-based desktop application designed to enable cashless transactions using NFC cards. It is tailored for public canteens in controlled environments. The system supports NFC card reading, transaction processing, and real-time data communication through serial ports.

---

## Features

- **Serial Port Communication**
  - Reads NFC card data via serial port (using RXTX or jSerialComm)
  - Outputs card and transaction info to connected display devices

- **Transaction Management**
  - Reload and withdrawal functionality
  - Seller and customer registration
  - Tracks all transactions for auditing

- **User Authentication**
  - Secure login for administrators and sellers
  - Role-based access control

- **MySQL Database Integration**
  - Stores customer, seller, and transaction data
  - Real-time data fetch and update

- **Intuitive User Interface**
  - Java Swing GUI
  - Views for transaction history, card balances, and user management

---

## Suitable Environments

This system is ideal for:

- University and college campus canteens  
- School cafeterias  
- Office and corporate food courts  
- Hospital canteens  
- Factory or industrial staff kitchens  
- Temporary event or camp-based food services  

> Best suited for public canteens in campuses, schools, offices, hospitals, factories, and other controlled environments where cashless transactions are preferred.

---

## Technologies Used

- **Java (Swing)** – for desktop GUI
- **MySQL** – for database and record management
- **RXTX / jSerialComm** – for serial port communication
- **NFC Reader Hardware** – integrated via COM port

---
---


## 🔌 Special Note for Future Developments

### Create New Account

Communication flow between PC and Arduino:

- `MAIN_NEWREG-OPENED`  
  _→ Sent from PC when "Create New Account" UI is opened_

- `MAIN_NEWREG-CARDOK`  
  _→ Sent from PC after receiving Card No from Arduino_

- `MAIN_NEWREG-PINOK`  
  _→ Sent from PC after receiving PIN from Arduino_

---

### SMS on Reload

After a successful reload, PC sends this to Arduino:
SMS_<contactNo>_<reloadAmount>

Example: SMS_+941234567_Rs.100.00

---

### TIP: Key Serial Commands

| Direction         | Command Prefix     | Description                  |
|------------------|--------------------|------------------------------|
| Arduino → PC     | `MAIN_CARD_`       | Send NFC card number         |
| Arduino → PC     | `MAIN_PSW_`        | Send PIN number              |


---

---

## 👤 Author

Designed & Developed by Akila Ranasinghe  
📧 Contact: wmakilaranasinghe@gmail.com


## ©️ License & Copyright

Copyright © 2018-2025 Akila Ranasinghe [Spyder Innovations]  
This project is open-source under the [Apache-2.0 license](LICENSE).  
Feel free to use, modify, and distribute with attribution.
