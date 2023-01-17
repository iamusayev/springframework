package az.iamusayev;

import az.iamusayev.spring.database.pool.ConnectionPool;
import az.iamusayev.spring.database.repository.CompanyRepository;
import org.postgresql.core.CachedQuery;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            String value = "hello";
            System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
            var connectionPool = context.getBean("p2", ConnectionPool.class);
            System.out.println(connectionPool);
            var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }
    }
}