package com.dmrval.hospitalapp.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "doctor")
public class Doctor {
    private int doctorid;
    private String firstname;
    private String lastname;
    private String specialization;
    private Date birthday;
    private Address address;
    private Doctorlicense doctorlicense;
    private User user;

    public Doctor() {
    }

    public Doctor(String birthday, String firstname, String lastname, String specialization,
                  Address address, Doctorlicense doctorlicense, User u) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
        this.address = address;
        this.doctorlicense = doctorlicense;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date_tmp = simpleDateFormat.parse(birthday);
            this.birthday = date_tmp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user = u;
    }

    public Doctor(String birthday, String firstname, String lastname, String specialization, Doctorlicense doctorlicense) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
        this.doctorlicense = doctorlicense;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date_tmp = simpleDateFormat.parse(birthday);
            this.birthday = date_tmp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Doctor(String birthday, String firstname, String lastname, String specialization) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialization = specialization;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date_tmp = simpleDateFormat.parse(birthday);
            this.birthday = date_tmp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Id
    @Column(name = "doctorid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
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
    @Column(name = "specialization", nullable = false, length = 255)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public void setDoctorlicense(Doctorlicense doctorlicense) {
        this.doctorlicense = doctorlicense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (doctorid != doctor.doctorid) return false;
        if (firstname != null ? !firstname.equals(doctor.firstname) : doctor.firstname != null) return false;
        if (lastname != null ? !lastname.equals(doctor.lastname) : doctor.lastname != null) return false;
        if (specialization != null ? !specialization.equals(doctor.specialization) : doctor.specialization != null)
            return false;
        if (birthday != null ? !birthday.equals(doctor.birthday) : doctor.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctorid;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "addressid", nullable = false)
    public Address getAddress() {
        return address;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorlicense", referencedColumnName = "doctorlicenseid", nullable = false)
    public Doctorlicense getDoctorlicense() {
        return doctorlicense;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "usr", referencedColumnName = "usrid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(("" + specialization).toUpperCase() + ", ");
        sb.append(firstname + ", ");
        sb.append(lastname + "; ");
        sb.append(give_BirsdayString());
        sb.append("; ");
        return sb.toString();
    }

    public String give_BirsdayString() {
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(birthday.getTime());
        sb.append("");
        if (cal.get(Calendar.DATE) < 10) {
            sb.append(0 + "" + cal.get(Calendar.DATE));
        } else
            sb.append(cal.get(Calendar.DATE));
        sb.append("-");
        if (cal.get(Calendar.MONTH) < 10) {
            sb.append(0 + "" + (cal.get(Calendar.MONTH) + 1));
        } else {
            sb.append((cal.get(Calendar.MONTH) + 1));
        }
        sb.append("-" + cal.get(Calendar.YEAR));
        return sb.toString();
    }

    public String give_BirsdayString_for_editPost() {
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(birthday.getTime());
        sb.append(cal.get(Calendar.YEAR));
        sb.append("-");
        if ((cal.get(Calendar.MONTH) + 1) < 10) {
            sb.append(0 + "" + (cal.get(Calendar.MONTH) + 1));
        } else {
            sb.append((cal.get(Calendar.MONTH) + 1));
        }
        sb.append("-");
        if (cal.get(Calendar.DATE) < 10) {
            sb.append(0 + "" + cal.get(Calendar.DATE));
        } else {
            sb.append(cal.get(Calendar.DATE));
        }
        return sb.toString();
    }


    public String giveDoctorlicense_Number() {
        long res = doctorlicense.getNumber();
        String result = String.valueOf(res);
        return result;
    }
}
