package com.bubble.knowledge.command.web;


import com.bubble.knowledge.command.repository.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionCommandController {

    // @Autowired
    // private QuestionCommandService questionCommandService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Question> saveQuestion() {
        Question question = new Question("Where is the nearest taxi rank?", 4L);
        return new ResponseEntity(question, HttpStatus.CREATED);
    }


}
