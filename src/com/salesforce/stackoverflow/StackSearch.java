package com.salesforce.stackoverflow;

import java.util.List;

public interface StackSearch {
    List<SearchResponse> search(SearchRequest search);
}
