package com.salesforce.stackoverflow;

public class SearchRequest {
    String searchDesc;
    Category category;

    public String getSearchDesc() {
        return searchDesc;
    }

    public void setSearchDesc(String searchDesc) {
        this.searchDesc = searchDesc;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SearchRequest() {
    }
}
