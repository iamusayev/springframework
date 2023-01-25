package az.iamusayev.spring.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component("pool1")
public class ConnectionPool  {

    private final String username;
    private final Integer poolSize;

    public ConnectionPool(@Value("{db.username}") String username, @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }


    @PostConstruct
    public void init() {
        System.out.println("Init connection pool");
    }


    @PreDestroy
    public void destroy() {
        System.out.println("Clean connection pool");
    }
}