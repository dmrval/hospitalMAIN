package com.dmrval.hospitalapp.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Visit {
    private int visitid;
    private Timestamp dayofvisit;
    private Doctor doctor;
    private Patient patient;
    private Diagnosis diagnosis;

    public Visit(Timestamp dayofvisit, Doctor doctor, Patient patient, Diagnosis diagnosis) {
        this.dayofvisit = dayofvisit;
        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
    }

    public Visit(Timestamp dayofvisit, Doctor doctor, Patient patient) {
        this.dayofvisit = dayofvisit;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Visit() {
    }

    @Id
    @Column(name = "visitid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getVisitid() {
        return visitid;
    }

    public void setVisitid(int visitid) {
        this.visitid = visitid;
    }

    @Basic
    @Column(name = "dayofvisit", nullable = false)
    public Timestamp getDayofvisit() {
        return dayofvisit;
    }

    public void setDayofvisit(Timestamp dayofvisit) {
        this.dayofvisit = dayofvisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        if (visitid != visit.visitid) return false;
        if (dayofvisit != null ? !dayofvisit.equals(visit.dayofvisit) : visit.dayofvisit != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = visitid;
        result = 31 * result + (dayofvisit != null ? dayofvisit.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "doctor", referencedColumnName = "doctorid", nullable = false)
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToOne
    @JoinColumn(name = "patient", referencedColumnName = "patientid", nullable = false)
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne
    @JoinColumn(name = "diagnosis", referencedColumnName = "diagnosisid")
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dayofvisit.getTime());
        sb.append("Дата и время: " + cal.get(Calendar.DATE) + "-" +
                (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.YEAR) + " " +
                cal.get(Calendar.HOUR) + ":"
        );
        if (cal.get(Calendar.MINUTE) < 9) {
            sb.append(0 + "" + cal.get(Calendar.MINUTE));
        } else sb.append(cal.get(Calendar.MINUTE));
        sb.append("; " + "Доктор: " + doctor.getFirstname() + " " + doctor.getLastname() + "; ");
        sb.append("Пациент: " + patient.getFirstname() + " " + patient.getLastname() + "; ");
        return sb.toString();
    }

    public String give_DateString() {
        String result = methodRemove_Char(dayofvisit.toString());
        return result;
    }


    public String give_ID_PATIENT_string() {
        return String.valueOf(patient.getPatientid());
    }

    private String methodRemove_Char(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str != null && str.length() > 0 && str.charAt(str.length() - 1) != ':') {
                str = str.substring(0, str.length() - 1);
            }
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }
}
