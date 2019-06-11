package com.dmrval.hospitalapp.config;

import com.dmrval.hospitalapp.dao.*;
import com.dmrval.hospitalapp.service.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



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

    /**
     * SERVICE
     *//*
    @Bean
    public DoctorlicenseService getDoctorlicenseService() {
        return new DoctorlicenseServiceImpl();
    }*/

    //Address
    @Bean
    public AddressService getAddressService() {
        return new AddressServiceImlp();
    }

    @Bean
    public AddressDao getAddressDao() {
        return new AddressDaoImpl();
    }

    //Doctor
    @Bean
    public DoctorService getDoctorService() {
        return new DoctorServiceImpl();
    }

    @Bean
    public DoctorDao getDoctorDao() {
        return new DoctorDaoImpl();
    }

    //Patient
    @Bean
    public PatientService getPatientService() {
        return new PatientServiceImpl();
    }

    @Bean
    public PatientDao getPatientDao() {
        return new PatientDaoImpl();
    }

    //Medicalpolicy
    @Bean
    public MedicalpolicyService getMedicalpolicyService() {
        return new MedicalpolicyServiceImpl();
    }

    @Bean
    public MedicalpolicyDao getMedicalpolicyDao() {
        return new MedicalpolicyDaoImpl();
    }

    //Visit
    @Bean
    public VisitService getVisitService() {
        return new VisitServiceImpl();
    }

    @Bean
    public VisitDao getVisitDao() {
        return new VisitDaoImpl();
    }

    //Diagnosis

    @Bean
    public DiagnosisService getDiagnosisService() {
        return new DiagnosisServiceImpl();
    }

    @Bean
    public DiagnosisDao getDiagnosisDao() {
        return new DiagnosisDaoImpl();
    }

    //User

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    //Role

    @Bean
    public RoleSevice roleService() {
        return new RoleServiceImpl();
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
