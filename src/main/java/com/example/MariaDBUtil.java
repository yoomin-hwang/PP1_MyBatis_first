package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBUtil {
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://walab.handong.edu:3306/p232_22200809", "p232_22200809", "BahSa2");
        } catch (ClassNotFoundException e) {
            System.out.println("driver error");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("conn error");
            throw new RuntimeException(e);
        }

        return con;
    }

//	public static void main(String[] args){
//        Connection con = MariaDBUtil.getConnection();
//        if(con == null){
//            System.out.println("not connected!!");
//        }else{
//            System.out.println("connected!!");
//        }
//    }
}