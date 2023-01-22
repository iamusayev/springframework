package az.iamusayev;

import az.iamusayev.spring.config.ApplicationConfiguration;
import az.iamusayev.spring.database.pool.ConnectionPool;
import az.iamusayev.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            var connectionPool = context.getBean("pool1");
            System.out.println(connectionPool);

            var companyRepository = context.getBean(CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}