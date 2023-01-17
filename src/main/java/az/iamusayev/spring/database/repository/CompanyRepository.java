package az.iamusayev.spring.database.repository;

import az.iamusayev.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static CompanyRepository of(ConnectionPool pool) {
        return new CompanyRepository(pool);
    }

}