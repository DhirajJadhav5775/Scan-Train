package com.Scan_Train.Scan_Train.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.Random;

@Entity
public class User {
    @Id
    private int Id;
    @Column
    private String FirstName;
    @Column
    private String LastName;
    @Column
    private String Email;
    @Column
    private String Password;
    @Transient
    private String ConPassword;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConPassword() {
        return ConPassword;
    }

    public void setConPassword(String conPassword) {
        ConPassword = conPassword;
    }

    public int otpGeneration()
    {
        Random random = new Random();
        int number = random.nextInt(999999);
        return number;
    }
}
