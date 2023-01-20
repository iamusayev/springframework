package az.iamusayev;

import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.pool.ConnectionPool;
import az.iamusayev.spring.database.repository.CompanyRepository;
import az.iamusayev.spring.database.repository.CrudRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            CrudRepository companyRepository = context.getBean("companyRepository",CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}