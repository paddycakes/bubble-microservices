package com.bubble.knowledge.query.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Collection<Answer> findByQuestionId(long questionId);
}
