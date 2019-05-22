package com.dmrval.hospitalapp;

import com.dmrval.hospitalapp.entity.Diagnosis;
import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Patient;
import com.dmrval.hospitalapp.entity.Visit;
import org.hibernate.SessionFactory;

import java.sql.Timestamp;

public class TestDebug {
    public static void main(String[] args) {
        Visit visit = new Visit(Timestamp.valueOf("2019-05-10 17:12:00.00"),
                new Doctor(),new Patient(),new Diagnosis());
        System.out.println(visit.give_DateString());
    }
}
