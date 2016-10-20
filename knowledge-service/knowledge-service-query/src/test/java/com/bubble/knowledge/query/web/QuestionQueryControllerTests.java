package com.bubble.knowledge.query.web;

import com.bubble.knowledge.query.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class QuestionQueryControllerTests {

    // TODO: Should seed database in this test class.

    @Value("${local.server.port}")
    private int port;

    @Test
    public void getQuestion() throws Exception {
        String url = "http://localhost:" + this.port + "/questions/1";
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
                url, String.class);
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(entity.getBody(), containsString("Where is the best pub?"));
    }

}