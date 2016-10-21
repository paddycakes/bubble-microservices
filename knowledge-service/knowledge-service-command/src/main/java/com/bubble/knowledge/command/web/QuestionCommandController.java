package com.bubble.knowledge.command.web;

import com.bubble.knowledge.command.service.QuestionCommandService;
import com.bubble.knowledge.common.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionCommandController {

    @Autowired
    private QuestionCommandService questionCommandService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question savedQuestion = questionCommandService.save(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }


}
