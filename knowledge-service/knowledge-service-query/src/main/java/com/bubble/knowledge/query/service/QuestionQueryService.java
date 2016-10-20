package com.bubble.knowledge.query.service;

import com.bubble.knowledge.query.repository.Question;
import com.bubble.knowledge.query.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Should this be a class or an interface?

@Service
// @Service("questionQueryService")
public class QuestionQueryService {

    @Autowired
    private QuestionRepository repository;

    public Question findById(String questionId) {
        Long id = Long.valueOf(questionId);
        return repository.findOne(id);
    }

}
