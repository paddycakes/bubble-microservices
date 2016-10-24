package com.bubble.knowledge.query.service;

import com.bubble.knowledge.common.Question;
import com.bubble.knowledge.query.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Should this be a class or an interface?

@Service
// @Service("questionQueryService")
public class QuestionQueryService {

    @Autowired
    private QuestionRepository repository;

    public Question findById(long id) {
        return repository.findOne(id);
    }

}
