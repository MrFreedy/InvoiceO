package controller;

import java.sql.*;


import controller.start.Initialization;

import service.database.DTBConnection;
import service.database.DTBActions;



public class MainApp {
    public static void main(String[] args) throws SQLException, InterruptedException {
        Initialization initialization = new Initialization();
        initialization.start();
        initialization.choiceStart();
    }
}