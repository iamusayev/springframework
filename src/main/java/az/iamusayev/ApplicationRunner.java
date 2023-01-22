package az.iamusayev;

import az.iamusayev.spring.config.ApplicationConfiguration;
import az.iamusayev.spring.database.pool.ConnectionPool;
import az.iamusayev.spring.database.repository.CrudRepository;
import az.iamusayev.spring.service.CompanyService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
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
            CompanyService companyService = context.getBean( CompanyService.class);
            System.out.println(companyService.findById(1));

//            var companyRepository = context.getBean(CrudRepository.class);
//            System.out.println(companyRepository.findById(1));
        }
    }
}