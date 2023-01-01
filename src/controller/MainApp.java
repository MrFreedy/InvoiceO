package controller;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import com.opencsv.exceptions.CsvException;
import menu.HomePage;


public class MainApp {
    public static void main(String[] args) throws IOException, CsvException {
        HomePage.main(null);
        try {
            String[] file = {"ocaml", "C:\\Users\\arthu\\Documents\\GitHub\\InvoiceO\\ocaml\\src\\main.ml"};
            Process p = Runtime.getRuntime().exec(file);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}