package az.iamusayev.spring.config;

import az.iamusayev.spring.database.pool.ConnectionPool;
import az.iamusayev.spring.database.repository.UserRepository;
import az.iamusayev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
public class ApplicationConfiguration {

    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 25);
    }



    @Bean
    @Profile("prod|web")
//    ! & |
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository();
    }

    @Bean
    public UserRepository userRepository3() {
        return new UserRepository();
    }
}
