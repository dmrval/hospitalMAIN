package com.dmrval.hospitalapp;

import com.dmrval.hospitalapp.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class TestDebug {
    public static void main(String[] args) {

        WorkCalendar workCalendar = new WorkCalendar();
        for (Timestamp t : workCalendar.getWorkCalendar()) {
            System.out.println(t);
        }

    }
}
