package com.Project;

import jakarta.persistence.*;

@Entity // for jpa to create a table
@Table(name="student")
public class StudentsData/// contain values needed for the student management system
{
    @Id // showing that id is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)// generating a id
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String fathersName;
    @Column
    private String address;
    @Column
    private String className;
    @Column
    private int phoneNumber;




    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "StudentsData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", fatherName='" + fathersName + '\'' +
                ", address='" + address + '\'' +
                ", className='" + className + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
