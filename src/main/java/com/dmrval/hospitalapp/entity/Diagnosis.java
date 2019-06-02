package com.dmrval.hospitalapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    private int diagnosisid;
    private String resultofdiagnosis;

    public Diagnosis() {
    }

    public Diagnosis(String resultofdiagnosis) {
        this.resultofdiagnosis = resultofdiagnosis;
    }

    @Id
    @Column(name = "diagnosisid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDiagnosisid() {
        return diagnosisid;
    }

    public void setDiagnosisid(int diagnosisid) {
        this.diagnosisid = diagnosisid;
    }

    @Basic
    @Column(name = "resultofdiagnosis", nullable = false, length = 1000)
    public String getResultofdiagnosis() {
        return resultofdiagnosis;
    }

    public void setResultofdiagnosis(String resultofdiagnosis) {
        this.resultofdiagnosis = resultofdiagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (diagnosisid != diagnosis.diagnosisid) return false;
        if (resultofdiagnosis != null ? !resultofdiagnosis.equals(diagnosis.resultofdiagnosis) : diagnosis.resultofdiagnosis != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisid;
        result = 31 * result + (resultofdiagnosis != null ? resultofdiagnosis.hashCode() : 0);
        return result;
    }

}
