package az.iamusayev;

import az.iamusayev.spring.database.pool.ConnectionPool;
import az.iamusayev.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool connectionPool = context.getBean("p2", ConnectionPool.class);
        CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        System.err.println(connectionPool + " " + companyRepository);
    }
}