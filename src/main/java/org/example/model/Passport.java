package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private int passportNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person citizen;

    public Passport() {
    }

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person getCitizen() {
        return citizen;
    }

    public void setCitizen(Person citizen) {
        this.citizen = citizen;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "citizen=" + citizen +
                ", passportNumber=" + passportNumber +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
