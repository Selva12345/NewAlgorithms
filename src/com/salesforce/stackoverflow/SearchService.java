package com.salesforce.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class SearchService  implements StackSearch{
    @Override
    public List<SearchResponse> search(SearchRequest search) {
        System.out.println("Searched Results: ");
        List<SearchResponse> searchResponseList=new ArrayList<>();

           QuestionRequest questionRequest= QuestionService.bank.get(search.getSearchDesc());
           SearchResponse searchResponse=new SearchResponse();
           searchResponse.setQuestion(questionRequest.getTopic());
           searchResponseList.add(searchResponse);
           for(SearchResponse searchResponse1:searchResponseList){
               System.out.println(searchResponse1.toString());
           }
        return searchResponseList;
    }


}
