package com.bubble.knowledge.command.repository;

import com.bubble.knowledge.common.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {


}
