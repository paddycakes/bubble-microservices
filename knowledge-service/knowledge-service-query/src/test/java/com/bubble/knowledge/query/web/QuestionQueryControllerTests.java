package com.bubble.knowledge.query.web;

import com.bubble.knowledge.common.Answer;
import com.bubble.knowledge.common.Question;
import com.bubble.knowledge.query.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class QuestionQueryControllerTests extends AbstractQueryControllerTests {

    // TODO: Should seed database in this test class.

    @Test
    public void should_return_success_for_request_for_existing_question() throws Exception {
        // Given
        String url = getUrl("/questions/1");

        // When
        ResponseEntity<Question> entity = new TestRestTemplate().getForEntity(url, Question.class);

        // Then
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(entity.getBody().getText(), containsString("Where is the best pub?"));
    }

    @Test
    public void should_return_not_found_status_for_request_for_unknown_question() throws Exception {
        // Given
        String url = getUrl("/questions/4");

        // When
        ResponseEntity<Question> entity = new TestRestTemplate().getForEntity(url, Question.class);

        // Then
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void should_return_success_for_request_for_existing_question_with_answers() throws Exception {
        // Given
        String url = getUrl("/questions/1/answers");

        // When
        ResponseEntity<Collection<Answer>> entity = new TestRestTemplate().exchange(url, HttpMethod.GET, null, getResponseType());

        // Then
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(entity.getBody().size(), is(2));
    }

    @Test
    public void should_return_not_found_status_for_request_for_answers_to_unknown_question() throws Exception {
        // Given
        String url = getUrl("/questions/4/answers");

        // When
        ResponseEntity<Collection<Answer>> entity = new TestRestTemplate().exchange(url, HttpMethod.GET, null, getResponseType());

        // Then
        assertThat(entity.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

    private ParameterizedTypeReference<Collection<Answer>> getResponseType() {
        return new ParameterizedTypeReference<Collection<Answer>>() {};
    }

}