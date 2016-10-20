package com.bubble.knowledge.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

// TODO: Should this be renamed to QuestionInfo to provide an
//       enriched structure around the db object?

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String text;

    private long userId;

    // private LocalDate created;

    public Question(String text, long userId) {
        this.text = text;
        this.userId = userId;
    }

    public Question() { }

    public String getText() {
        return text;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return text + " " + userId;
    }
}
