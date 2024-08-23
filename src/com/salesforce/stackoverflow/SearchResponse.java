package com.salesforce.stackoverflow;

import java.util.List;

public class SearchResponse {
    String topic;

    String topicId;
    String question;
    Category category;
    List<Replies> repliesList;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Replies> getRepliesList() {
        return repliesList;
    }

    public void setRepliesList(List<Replies> repliesList) {
        this.repliesList = repliesList;
    }
    @Override
    public String toString() {
        return topic+"-"+question+"-"+topicId;
    }
}
