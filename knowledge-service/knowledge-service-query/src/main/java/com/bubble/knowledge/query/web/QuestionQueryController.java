package com.bubble.knowledge.query.web;

import com.bubble.knowledge.common.Answer;
import com.bubble.knowledge.common.Question;
import com.bubble.knowledge.query.service.AnswerQueryService;
import com.bubble.knowledge.query.service.QuestionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/questions")
public class QuestionQueryController {

    @Autowired
    private QuestionQueryService questionQueryService;
    @Autowired
    private AnswerQueryService answerQueryService;

    @RequestMapping(value = "/{questionId}", method = RequestMethod.GET)
    public ResponseEntity<Question> findQuestion(@PathVariable("questionId") String questionId) {
        Question q = questionQueryService.findById(questionId);
        return q == null ?  new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(q);
    }

    @RequestMapping(value = "/{questionId}/answers", method = RequestMethod.GET)
    public ResponseEntity<Collection<Answer>> findAnswers(@PathVariable("questionId") String questionId) {
        if (unknownQuestion(questionId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Collection<Answer> answers = answerQueryService.getAnswers(questionId);
        return ResponseEntity.ok(answers);
    }

    private boolean unknownQuestion(String questionId) {
        Question question = questionQueryService.findById(questionId);
        return question == null ? true : false;
    }

}
