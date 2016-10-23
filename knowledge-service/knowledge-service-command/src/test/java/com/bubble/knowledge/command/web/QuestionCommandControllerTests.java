package com.bubble.knowledge.command.web;

import com.bubble.knowledge.command.Application;
import com.bubble.knowledge.common.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class QuestionCommandControllerTests {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void should_create_a_new_question() throws Exception {
        String url = "http://localhost:" + this.port + "/questions/";
        Question question = new Question("Where is the nearest taxi rank?", 4L);
        ResponseEntity<Question> entity = new TestRestTemplate().postForEntity(url, question, Question.class);
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(entity.getBody().getId(), is(1L));
    }

}