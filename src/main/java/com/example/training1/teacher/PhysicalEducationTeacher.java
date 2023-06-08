package com.example.training1.teacher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("physicalEducation")
public class PhysicalEducationTeacher implements Teacher{
    @Override
    public String pleaseLearn() {
        return "Make 10 push-ups a day!";
    }
}
