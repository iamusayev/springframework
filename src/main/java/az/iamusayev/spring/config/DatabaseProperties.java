package az.iamusayev.spring.config;

import java.util.List;
import java.util.Map;
import lombok.Data;

//@Data
//@NoArgsConstructor
//@ConfigurationProperties(prefix = "db")
//@Component
@Data
public class DatabaseProperties {

    private String username;
    private String password;
    private String driver;
    private String hosts;
    private PoolProperties pool;
    private List<PoolProperties> pools;
    private Map<String, Object> properties;


    @Data
    public static class PoolProperties {
        private Integer size;
        private Integer timeout;
    }
}
