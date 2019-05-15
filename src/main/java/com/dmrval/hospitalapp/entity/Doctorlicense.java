package com.dmrval.hospitalapp.entity;

import javax.persistence.*;

@Entity
public class Doctorlicense {
    private int doctorlicenseid;
    private long number;


    public Doctorlicense(long number) {
        this.number = number;
    }

    public Doctorlicense() {
    }

    @Id
    @Column(name = "doctorlicenseid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDoctorlicenseid() {
        return doctorlicenseid;
    }

    public void setDoctorlicenseid(int doctorlicenseid) {
        this.doctorlicenseid = doctorlicenseid;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctorlicense that = (Doctorlicense) o;

        if (doctorlicenseid != that.doctorlicenseid) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctorlicenseid;
        result = (int) (31 * result + number);
        return result;
    }
}
