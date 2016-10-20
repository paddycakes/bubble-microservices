package com.bubble.knowledge.command.service;

import com.bubble.knowledge.command.repository.Question;
import com.bubble.knowledge.command.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionCommandService {

    @Autowired
    private QuestionRepository repository;

    public Question save(Question question) {
        return repository.save(question);
    }
}
