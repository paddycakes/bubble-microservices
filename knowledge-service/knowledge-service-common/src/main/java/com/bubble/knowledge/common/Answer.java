package com.bubble.knowledge.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private long id;

    private String text;
    private long questionId;
    private long userId;

    public Answer(String text, long questionId, long userId) {
        this.text = text;
        this.questionId = questionId;
        this.userId = userId;
    }

    public Answer() { }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public long getQuestionId() {
        return questionId;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return id + " " + text + " " + questionId + " " + userId;
    }

}
