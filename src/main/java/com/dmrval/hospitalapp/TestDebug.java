package com.dmrval.hospitalapp;

import com.dmrval.hospitalapp.entity.*;

import java.sql.Timestamp;


public class TestDebug {
    public static void main(String[] args) {

        WorkCalendar workCalendar = new WorkCalendar();
        for (Timestamp t : workCalendar.getWorkCalendar()) {
            System.out.println(t);
        }

    }
}
