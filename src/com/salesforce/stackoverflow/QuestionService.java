package com.salesforce.stackoverflow;

import java.util.HashMap;
import java.util.Map;

public class QuestionService implements Question {
   static Map<String,QuestionRequest> bank=new HashMap<>();
    @Override
    public void askQuestion(QuestionRequest question) throws Exception {
        System.out.println("Question created");
        bank.put(question.getTopic(),question);
    }
}
