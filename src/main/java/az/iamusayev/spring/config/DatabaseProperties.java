package az.iamusayev.spring.config;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@Data
//@NoArgsConstructor
//@ConfigurationProperties(prefix = "db")
//@Component
@ConfigurationProperties(prefix = "db")
public record DatabaseProperties(String username,
                                 String password,
                                 String driver,
                                 String hosts,
                                 PoolProperties pool,
                                 List<PoolProperties> pools,
                                 Map<String, Object> properties
) {


    public record PoolProperties(Integer size,
                                 Integer timeout) {

    }
}
