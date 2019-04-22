package source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("source.domain.entity")
@EnableJpaRepositories("source.domain.repository")
public class McmApplication {
    public static void main(String[] args) {
        SpringApplication.run(McmApplication.class, args);
    }
}

