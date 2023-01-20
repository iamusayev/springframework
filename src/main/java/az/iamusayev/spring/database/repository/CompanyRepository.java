package az.iamusayev.spring.database.repository;

import az.iamusayev.spring.bpp.Auditing;
import az.iamusayev.spring.bpp.InjectBean;
import az.iamusayev.spring.bpp.Transaction;
import az.iamusayev.spring.database.entity.Company;
import az.iamusayev.spring.database.pool.ConnectionPool;
import java.util.Optional;
import javax.annotation.PostConstruct;


@Auditing
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    public void init() {
        System.out.println("init company repository");
    }


    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method....");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method....");
    }
}




