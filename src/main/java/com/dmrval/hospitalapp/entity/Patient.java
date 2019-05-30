package com.dmrval.hospitalapp.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Patient {
    private int patientid;
    private String firstname;
    private String lastname;
    private Date birthday;
    private Address address;
    private Medicalpolicy medicalpolicy;
    private User user;


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
        if (birthday != null) {
            this.birthday = birthday;
        }
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "usrid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstname + ", ");
        sb.append(lastname + "; ");
        sb.append(give_BirsdayString());
        sb.append("; ");
        sb.append("Мед.полис: " + Math.abs(medicalpolicy.getNumber()) + ".");
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

    public String giveMedicalpolicy_Number() {
        long res = medicalpolicy.getNumber();
        String result = String.valueOf(res);
        return result;
    }
}
