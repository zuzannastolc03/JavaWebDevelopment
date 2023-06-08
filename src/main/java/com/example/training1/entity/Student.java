package com.example.training1.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="class")
    private String className;

    public Student() {
    }

    public Student(String lastName, String firstName, String className) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.className = className;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
