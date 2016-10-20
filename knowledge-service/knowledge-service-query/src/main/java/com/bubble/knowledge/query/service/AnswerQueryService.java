package com.bubble.knowledge.query.service;

import com.bubble.knowledge.query.repository.Answer;
import com.bubble.knowledge.query.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AnswerQueryService {

    @Autowired
    private AnswerRepository repository;

    public Collection<Answer> getAnswers(String questionId) {
        Long id = Long.valueOf(questionId);
        return repository.findByQuestionId(id);
    }
}
