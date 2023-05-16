package com.example.training1.teacher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("english")
public class EnglishTeacher implements Teacher{
    @Override
    public String pleaseLearn() {
        return "Practise modal verbs!";
    }
}
