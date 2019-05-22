package com.dmrval.hospitalapp.entity;

import javax.persistence.*;

@Entity
public class Medicalpolicy {
    private int medicalpolicyid;

    private long number;

    public Medicalpolicy(long number) {
        this.number = number;
    }

    public Medicalpolicy() {
    }

    @Id
    @Column(name = "medicalpolicyid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMedicalpolicyid() {
        return medicalpolicyid;
    }

    public void setMedicalpolicyid(int medicalpolicyid) {
        this.medicalpolicyid = medicalpolicyid;
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

        Medicalpolicy that = (Medicalpolicy) o;

        if (medicalpolicyid != that.medicalpolicyid) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = medicalpolicyid;
        result = 31 * result + number;
        return (int) result;
    }

    @Override
    public String toString() {
        return getNumber() + "";
    }
}
