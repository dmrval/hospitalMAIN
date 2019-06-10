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
//        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
//        sessionFactory.getCurrentSession().beginTransaction();
//

//        WorkCalendar workCalendar = new WorkCalendar();
//
//        long d = 0L;
//        for (Calendar cal:workCalendar.getWorkCalendar()
//             ) {
//            System.out.println(cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE) +
//                    " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));
//            d = cal.getTimeInMillis();
//        }
//
//        Calendar ret = Calendar.getInstance();
//        ret.setTimeInMillis(d);
//        System.out.println(ret);
//        System.out.println(ret.get(Calendar.YEAR) + "-" + ret.get(Calendar.MONTH) + "-" + ret.get(Calendar.DATE) +
//                " " + ret.get(Calendar.HOUR_OF_DAY) + ":" + ret.get(Calendar.MINUTE));


        String s = "3 567 567 789 789";
//        s = s.replaceAll("\\s+","");
        System.out.println(s);


//
//        sessionFactory.getCurrentSession().getTransaction().commit();
//        sessionFactory.getCurrentSession().close();

//        String str = "2019-06-21T12:12";
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(str.getTime());

    }
}
