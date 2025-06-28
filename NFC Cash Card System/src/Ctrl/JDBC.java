/*
 * Copyright (c) 2018 Spyder Innovations </Akila Ranasinghe>
 * All rights reserved.
 */
package Ctrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author AKILA
 */
public class JDBC {

    private static Connection c = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static synchronized Connection mycon() throws Exception {
        if (c == null) {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cash_card_system", "root", "1234");
        }
        return c;
    }

    public static synchronized void putData(String sql) {
        try {
            stmt = mycon().createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "JDBC Exception_s/u", 0);
        }
    }

    public static synchronized ResultSet getData(String sql) {
        try {
            stmt = mycon().createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "JDBC Exception_R", 0);
        }
        return rs;
    }
}
