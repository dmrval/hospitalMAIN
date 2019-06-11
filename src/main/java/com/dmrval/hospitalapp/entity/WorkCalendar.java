package com.dmrval.hospitalapp.entity;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class WorkCalendar {
    List<Timestamp> workCalendar = new ArrayList<>();


    public WorkCalendar(List<Timestamp> workCalendar) {
        this.workCalendar = workCalendar;
    }

    public WorkCalendar() {
        Calendar current = Calendar.getInstance();
        for (int k = 0; k < 7; k++) {
            current.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DATE),
                    9, 0, 0);
            current.set(Calendar.MILLISECOND, 0);
            Calendar checkWeekend = Calendar.getInstance();
            checkWeekend.set(Calendar.DAY_OF_WEEK, current.get(Calendar.DAY_OF_WEEK) + 1 + k);
            if (checkWeekend.get(Calendar.DAY_OF_WEEK) == 1) {
                continue;
            }
            for (int i = 0; i < 9; i++) {
                Calendar temp = Calendar.getInstance();
                temp.set(Calendar.MILLISECOND, 0);
                temp.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DATE) + 1 + k,
                        current.get(Calendar.HOUR_OF_DAY) + i, current.get(Calendar.MINUTE), 0);
                workCalendar.add(new Timestamp(temp.getTimeInMillis()));
            }
        }
    }

    public List<Timestamp> getWorkCalendar() {
        return workCalendar;
    }

    public int checkPosition_OfWorkCalendar(Timestamp t) {
        int count = 0;
        for (Timestamp current : workCalendar) {
            if (current.compareTo(t) == 0) {
                return count;
            }
            count++;
        }
        return -1;
    }

}
