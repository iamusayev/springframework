package az.iamusayev.spring.database.repository;

import az.iamusayev.spring.bpp.Auditing;
import az.iamusayev.spring.bpp.Transaction;
import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.pool.ConnectionPool;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {


    //    @Resource(name = "pool1")
//    @Qualifier("pool1")
//    @Autowired
    private ConnectionPool pool1;
    @Autowired
    private List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private Integer poolSize;

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

    @Autowired
    public void setPool2(ConnectionPool pool1) {
        this.pool1 = pool1;
    }
}