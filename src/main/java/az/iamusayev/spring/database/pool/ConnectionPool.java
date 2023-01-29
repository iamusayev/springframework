package az.iamusayev.spring.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("pool1")
@Slf4j
public class ConnectionPool {

    private final String username;
    private final Integer poolSize;

    public ConnectionPool(@Value("${db.username}") String username,
            @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }


    @PostConstruct
    public void init() {
        log.info("Init connection pool");
    }


    @PreDestroy
    public void destroy() {
        log.info("Clean connection pool");
    }
}