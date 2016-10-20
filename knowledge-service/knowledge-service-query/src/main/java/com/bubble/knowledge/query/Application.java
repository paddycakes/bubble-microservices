package com.bubble.knowledge.query;

// import com.bubble.knowledge.common.Question;
import com.bubble.knowledge.query.repository.Question;
import com.bubble.knowledge.query.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Bean
    public InitializingBean seedDatabase(QuestionRepository repository) {
        return () -> {
            repository.save(new Question("Where is the best pub?", 1L));
            repository.save(new Question("Is there a tube nearby?", 2L));
            repository.save(new Question("Can anyone recommend a great coffee shop?", 3L));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
