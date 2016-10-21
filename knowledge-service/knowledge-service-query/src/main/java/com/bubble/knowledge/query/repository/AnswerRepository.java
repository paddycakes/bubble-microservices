package com.bubble.knowledge.query.repository;

import com.bubble.knowledge.common.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Collection<Answer> findByQuestionId(long questionId);
}
