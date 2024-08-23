package com.salesforce.stackoverflow;

import java.util.List;

public class MainApp {
    public static void main(String[] args) throws Exception {


        QuestionRequest question = new QuestionRequest();
        List<Tag> tagList = List.of(new Tag());
        question.setQuestionDesc("Low level design");
        question.setTopic("LLD");
        question.setTags(tagList);
        Question question1=new QuestionService();
        question1.askQuestion(question);

        SearchRequest searchRequest =new SearchRequest();

        searchRequest.setSearchDesc("LLD");
        searchRequest.setCategory(Category.SoftwareEngineering);

        SearchService service=new SearchService();
        List<SearchResponse> response=service.search(searchRequest);

        System.out.println(response);

    }
}
