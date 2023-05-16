package com.example.training1.teacher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("maths")
public class MathsTeacher implements Teacher{
    @Override
    public String pleaseLearn() {
        return "Calculate 10 exercises with square roots!";
    }
}
