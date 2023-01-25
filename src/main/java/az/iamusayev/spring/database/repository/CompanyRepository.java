package az.iamusayev.spring.database.repository;

import az.iamusayev.spring.bpp.Auditing;
import az.iamusayev.spring.bpp.Transaction;
import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.pool.ConnectionPool;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Transaction
@Auditing
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyRepository implements CrudRepository<Integer, Company> {


    //    @Resource(name = "pool1")
//    @Qualifier("pool1")
//    @Autowired
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
            List<ConnectionPool> pools,
            @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method");
        return Optional.of(new Company(id));
    }

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method");
    }

}