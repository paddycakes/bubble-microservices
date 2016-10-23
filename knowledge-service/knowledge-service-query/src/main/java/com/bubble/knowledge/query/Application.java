package com.bubble.knowledge.query;

import com.bubble.knowledge.common.Answer;
import com.bubble.knowledge.common.Question;
import com.bubble.knowledge.query.repository.AnswerRepository;
import com.bubble.knowledge.query.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.bubble.knowledge.common")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    public InitializingBean seedDatabase(QuestionRepository questionRepository,
                                         AnswerRepository answerRepository) {
        return () -> {
            seedQuestions(questionRepository);
            seedAnswers(answerRepository);
        };
    }

    private void seedQuestions(QuestionRepository repository) {
        repository.save(new Question("Where is the best pub?", 1L));
        repository.save(new Question("Is there a tube nearby?", 2L));
        repository.save(new Question("Can anyone recommend a great coffee shop?", 3L));
    }

    private void seedAnswers(AnswerRepository repository) {
        repository.save(new Answer("The Dog and Duck on Hoppers Lane", 1L, 4L));
        repository.save(new Answer("The Salisbury Arms by the Green.", 1L, 2L));
        repository.save(new Answer("Eco-Coffee do great coffees.", 2L, 3L));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
