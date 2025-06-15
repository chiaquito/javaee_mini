package mini.domain.repository;

import java.sql.SQLException;
import java.util.List;

import mini.config.application.javaee.Context;
import mini.domain.model.Company;

public interface CompanyRepository {
    // get all items
    public List<Company> findAll() throws SQLException;
    // retrieve Company by id
    public Company getById(Integer id);
    // create Company
    public void create(Context ctx, String name, String establishedDate, Integer createUserId);
}
