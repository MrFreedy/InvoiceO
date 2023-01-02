/*
 * Copyright (c) 2022-2023.
 * Lenne Arthur
 */

package dao;

import domain.DTBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;

public class Dao {
    private static ZonedDateTime currentTime = ZonedDateTime.now();
    private static int hour = currentTime.getHour();
    private static int minute = currentTime.getMinute();
    private static int second = currentTime.getSecond();
    private static int day = currentTime.getDayOfMonth();
    private static int month = currentTime.getMonthValue();
    private static int year = currentTime.getYear();
    public static void main(String[] args) throws InterruptedException, IOException {
        String[] cmd = {"cmd.exe", "/c", "echo", "Logged at "+hour+":"+minute+":"+second+" on "+year+"/"+month+"/"+day+" with "+ DTBConnection.user, ">", "log.txt"};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        String[] file = {"ocaml", "ocaml\\src\\main.ml"};
        Process p2 = Runtime.getRuntime().exec(file);
        BufferedReader in = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }
}
