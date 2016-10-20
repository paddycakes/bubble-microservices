package com.bubble.knowledge.query.web;

// import com.bubble.knowledge.common.Question;
import com.bubble.knowledge.query.repository.Question;
import com.bubble.knowledge.query.service.QuestionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionQueryController {

    @Autowired
    private QuestionQueryService questionQueryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> findQuestion(@PathVariable("id") String questionId) {
        Question q = questionQueryService.findById(questionId);
        return q == null ?  new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(q);
    }


}
