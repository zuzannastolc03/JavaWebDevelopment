package com.example.training1;

import com.example.training1.dao.*;
import com.example.training1.entity.Grade;
import com.example.training1.entity.Student;
import com.example.training1.entity.Subject;
import com.example.training1.entity.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Training1Application {

    public static void main(String[] args) {
        SpringApplication.run(Training1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO, TeacherDAO teacherDAO, SubjectDAO subjectDAO, GradeDAO gradeDAO) {
        return runner -> {
//            create Students
//            createStudent(studentDAO, "Brown", "John", "1a");
//            createStudent(studentDAO, "Jones", "Mary", "2c");
//            createStudent(studentDAO, "Taylor", "Marcus", "3b");

//            create Teachers
//            createTeacher(teacherDAO, "Williams", "Henry");
//            createTeacher(teacherDAO, "Jackson", "Michael");
//            createTeacher(teacherDAO, "Johnson", "Alexander");

//            create Subjects
//            createSubject(subjectDAO, "maths");
//            createSubject(subjectDAO, "english");
//            createSubject(subjectDAO, "physical education");

//            create a new grade
//            createGrade(gradeDAO, 5, 1, 1, 1);
//            createGrade(gradeDAO, 4, 2, 2, 2);

//            read information at a specific id
//            readStudent(studentDAO, 1);
//            readTeacher(teacherDAO, 1);
//            readSubject(subjectDAO, 1);
//            readGrade(gradeDAO, 1);

//            list all elements from each table
//            listStudents(studentDAO);
//            listTeachers(teacherDAO);
//            listSubjects(subjectDAO);
//            listGrades(gradeDAO);

//            more specific queries
//            listStudentsWithGivenLastName(studentDAO, "Jones");
//            listTeachersWithGivenLastName(teacherDAO, "Jackson");
//            listSubjectsWithGivenName(subjectDAO, "maths");

//            update cells in a DB
//            updateStudent(studentDAO, 1, "Evans");
//            updateTeacher(teacherDAO, 1, "Robinson");
//            updateGrade(gradeDAO, 1, 1);

//            delete objects from a table in a DB
//            It is only possible to delete objects, which are not connected to another table of a DB by a foreign key
//            deleteStudent(studentDAO, 6);
//            deleteTeacher(teacherDAO, 3);
//            deleteGrade(gradeDAO, 1);

//            delete all objects from a table in a DB
//            nothing else I could delete-all -> rest of the tables are connected with a foreign key
//            deleteAllGrades(gradeDAO);
        };
    }

    private void deleteAllGrades(GradeDAO gradeDAO) {
        int numRowsDeleted = gradeDAO.deleteAllGrades();
        System.out.println("Deleted "+ numRowsDeleted + " rows");
    }

    private void deleteGrade(GradeDAO gradeDAO, int id) {
        gradeDAO.deleteGrade(id);
    }

    private void deleteTeacher(TeacherDAO teacherDAO, int id) {
        teacherDAO.deleteTeacher(id);
    }


    private void deleteStudent(StudentDAO studentDAO, int id) {
        studentDAO.deleteStudent(id);
    }

    private void updateGrade(GradeDAO gradeDAO, int id, int grade) {
        Grade tempGrade = gradeDAO.findById(id);
        tempGrade.setGrade(grade);
        gradeDAO.updateGrade(tempGrade);
    }

    private void updateTeacher(TeacherDAO teacherDAO, int id, String lastName) {
        Teacher tempTeacher = teacherDAO.findById(id);
        tempTeacher.setLastName(lastName);
        teacherDAO.updateTeacher(tempTeacher);
    }

    private void updateStudent(StudentDAO studentDAO, int id, String lastName) {
        Student tempStudent = studentDAO.findById(id);
        tempStudent.setLastName(lastName);
        studentDAO.updateStudent(tempStudent);
    }

    private void listSubjectsWithGivenName(SubjectDAO subjectDAO, String name) {
        List<Subject> theSubjects = subjectDAO.findByName(name);
        for (Subject subject : theSubjects) {
            System.out.println(subject);
        }
    }

    private void listTeachersWithGivenLastName(TeacherDAO teacherDAO, String lastName) {
        List<Teacher> theTeachers = teacherDAO.findByLastName(lastName);
        for (Teacher teacher : theTeachers) {
            System.out.println(teacher);
        }
    }

    private void listStudentsWithGivenLastName(StudentDAO studentDAO, String lastName) {
        List<Student> theStudents = studentDAO.findByLastName(lastName);
        for (Student student : theStudents) {
            System.out.println(student);

        }
    }

    private void listTeachers(TeacherDAO teacherDAO) {
        List<Teacher> theTeachers = teacherDAO.findAll();
        for (Teacher teacher : theTeachers) {
            System.out.println(teacher);
        }
    }

    private void listSubjects(SubjectDAO subjectDAO) {
        List<Subject> theSubject = subjectDAO.findAll();
        for (Subject subject : theSubject) {
            System.out.println(subject);
        }
    }

    private void listStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();
        for (Student student : theStudents) {
            System.out.println(student);
        }
    }

    private void listGrades(GradeDAO gradeDAO) {
        List<Grade> theGrades = gradeDAO.findAll();
        for (Grade grade : theGrades) {
            System.out.println(grade);
        }
    }

    private void readGrade(GradeDAO gradeDAO, int id) {
        Grade tempGrade = gradeDAO.findById(id);
        System.out.println(tempGrade);
    }

    private void readSubject(SubjectDAO subjectDAO, int id) {
        Subject tempSubject = subjectDAO.findById(id);
        System.out.println(tempSubject);
    }

    private void readTeacher(TeacherDAO teacherDAO, int id) {
        Teacher tempTeacher = teacherDAO.findById(id);
        System.out.println(tempTeacher);
    }

    private void readStudent(StudentDAO studentDAO, int id) {
        Student tempStudent = studentDAO.findById(id);
        System.out.println(tempStudent);
    }

    private void createGrade(GradeDAO gradeDAO, int grade, int studentId, int teacherId, int subjectId) {
        System.out.println("Creating a new grade " + grade + " for student number " + studentId + " by teacher number " + teacherId + " from subject number " + subjectId);
        Grade tempGrade = new Grade(grade, studentId, teacherId, subjectId);
        System.out.println("Saving the grade...");
        gradeDAO.save(tempGrade);
        System.out.println("Saved grade at id: " + tempGrade.getId());
    }

    private void createSubject(SubjectDAO subjectDAO, String name) {
        System.out.println("Creating new subject " + name);
        Subject tempSubject = new Subject(name);
        System.out.println("Saving the subject...");
        subjectDAO.save(tempSubject);
        System.out.println("Saved subject at id: " + tempSubject.getId());
    }

    private void createTeacher(TeacherDAO teacherDAO, String lastName, String firstName) {
        System.out.println("Creating new teacher " + lastName + " " + firstName);
        Teacher tempTeacher = new Teacher(lastName, firstName);
        System.out.println("Saving the teacher...");
        teacherDAO.save(tempTeacher);
        System.out.println("Saved teacher at id: " + tempTeacher.getId());
    }

    private void createStudent(StudentDAO studentDAO, String lastName, String firstName, String className) {
        System.out.println("Creating new student " + lastName + " " + firstName);
        Student tempStudent = new Student(lastName, firstName, className);
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);
        System.out.println("Saved student at id: " + tempStudent.getId());
    }

}
