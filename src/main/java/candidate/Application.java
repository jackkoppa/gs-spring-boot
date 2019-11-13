package candidate;

import candidate.Candidate;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.stream.Stream;


@EnableSwagger2
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");


        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Bean
  ApplicationRunner init(CandidateRepository repository) {

    String[][] data = {
        {"sea", "Andrewwwwww", "300.12", "NDK"},
        {"creek", "Andrew", "100.75", "Piranha"},
        {"loaner", "Andrew", "75", "Necky"}
    };

    return args -> {
      Stream.of(data).forEach(array -> {
        try {
          Candidate candidate = new Candidate(
              array[0],
              array[1],
                  NumberFormat.getInstance().parse(array[2]),
              array[3]
          );
          repository.save(candidate);
        }
        catch (ParseException e) {
          e.printStackTrace();
        }
      });
      repository.findAll().forEach(System.out::println);
    };
  }

}
