package com.example.training1.entity;

import jakarta.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_id")
    private int id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;

    public Teacher() {
    }

    public Teacher(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
