package com.bubble.knowledge.command.web;

import com.bubble.knowledge.command.service.AnswerCommandService;
import com.bubble.knowledge.command.service.QuestionCommandService;
import com.bubble.knowledge.common.Answer;
import com.bubble.knowledge.common.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionCommandController {

    @Autowired
    private QuestionCommandService questionCommandService;
    @Autowired
    private AnswerCommandService answerCommandService;

    // TODO: Add a Location header that points to the URL of the new resource.
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question savedQuestion = questionCommandService.save(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{questionId}/answers", method = RequestMethod.POST)
    public ResponseEntity<Answer> addAnswer(@PathVariable("questionId") int questionId, @RequestBody Answer answer) {
        if (unknownQuestion(questionId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Answer savedAnswer = answerCommandService.save(answer);
        return new ResponseEntity<>(savedAnswer, HttpStatus.CREATED);
    }

    // TODO: This could be common functionality. Would also need teh QuestionQueryService in common.
    private boolean unknownQuestion(int questionId) {
        return false;
    }

}
