package com.dmrval.hospitalapp.config;

import com.dmrval.hospitalapp.dao.*;
import com.dmrval.hospitalapp.service.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    //SessionFactory
    @Bean
    public SessionFactory buildSessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    //Doctorlicense
    @Bean
    public DoctorlicenseDao getDoctorlicenseDao() {
        return new DoctorlicenseDaoImpl();
    }

    @Bean
    public DoctorlicenseServise getDoctorlicenseServise() {
        return new DoctorlicenseServiseImpl();
    }

    //Address
    @Bean
    public AddressServise getAddressServise() {
        return new AddressServiseImlp();
    }

    @Bean
    public AddressDao getAddressDao() {
        return new AddressDaoImpl();
    }

    //Doctor
    @Bean
    public DoctorServise getDoctorServise() {
        return new DoctorServiseImpl();
    }

    @Bean
    public DoctorDao getDoctorDao() {
        return new DoctorDaoImpl();
    }

    //Patient
    @Bean
    public PatientServise getPatientServise() {
        return new PatientServiseImpl();
    }

    @Bean
    public PatientDao getPatientDao() {
        return new PatientDaoImpl();
    }

    //Medicalpolicy
    @Bean
    public MedicalpolicyServise getMedicalpolicyServise() {
        return new MedicalpolicyServiseImpl();
    }

    @Bean
    public MedicalpolicyDao getMedicalpolicyDao() {
        return new MedicalpolicyDaoImpl();
    }

    //Visit
    @Bean
    public VisitServise getVisitServise() {
        return new VisitServiseImpl();
    }

    @Bean
    public VisitDao getVisitDao() {
        return new VisitDaoImpl();
    }

    //Diagnosis

    @Bean
    public DiagnosisServise getDiagnosisServise() {
        return new DiagnosisServiseImpl();
    }

    @Bean
    public DiagnosisDao getDiagnosisDao() {
        return new DiagnosisDaoImpl();
    }


}
