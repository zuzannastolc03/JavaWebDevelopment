package com.example.training1.entity;

import jakarta.persistence.*;

@Entity
@Table(name="grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="grade_id")
    private int id;
    @Column(name="grade")
    private int grade;
    @Column(name="student_id")
    private int student_id;
    @Column(name="teacher_id")
    private int teacher_id;
    @Column(name="subject_id")
    private int subject_id;

    public Grade() {
    }

    public Grade(int grade, int student_id, int teacher_id, int subject_id) {
        this.grade = grade;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.subject_id = subject_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", student_id=" + student_id +
                ", teacher_id=" + teacher_id +
                ", subject_id=" + subject_id +
                '}';
    }
}
