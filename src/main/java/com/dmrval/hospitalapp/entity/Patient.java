package com.dmrval.hospitalapp.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Patient {
    private int patientid;
    private String firstname;
    private String lastname;
    private Date birthday;
    private Address address;
    private Medicalpolicy medicalpolicy;

    public Patient() {
    }

    public Patient(String firstname, String lastname, String birthday,
                   Address address, Medicalpolicy medicalpolicy) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.medicalpolicy = medicalpolicy;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date_tmp = simpleDateFormat.parse(birthday);
            this.birthday = date_tmp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Id
    @Column(name = "patientid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 255)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (patientid != patient.patientid) return false;
        if (firstname != null ? !firstname.equals(patient.firstname) : patient.firstname != null) return false;
        if (lastname != null ? !lastname.equals(patient.lastname) : patient.lastname != null) return false;
        if (birthday != null ? !birthday.equals(patient.birthday) : patient.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientid;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "addressid", nullable = false)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicalpolicy", referencedColumnName = "medicalpolicyid", nullable = false)
    public Medicalpolicy getMedicalpolicy() {
        return medicalpolicy;
    }

    public void setMedicalpolicy(Medicalpolicy medicalpolicy) {
        this.medicalpolicy = medicalpolicy;
    }
}
