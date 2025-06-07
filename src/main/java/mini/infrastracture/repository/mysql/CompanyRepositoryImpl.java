package mini.infrastracture.repository.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import mini.config.db.mysql.DBConfig;
import mini.domain.model.Company;
import mini.domain.repository.CompanyRepository;

public class CompanyRepositoryImpl implements CompanyRepository {
    
    @Override
    public List<Company> findAll() throws SQLException {

        String sql = "SELECT id, name FROM company";
        try (Connection conn = DBConfig.getDataSource().getConnection()) {
            QueryRunner runner = new QueryRunner();
            
            List<CompanyTableModel> res = runner.query(conn, sql, new BeanListHandler<>(CompanyTableModel.class));
            return CompanyTableModel.toModels(res);
        }
    }

    @Override
    public Company getById(Integer id) {

        String sql = "SELECT id, name FROM company where id = ?";
        QueryRunner runner = new QueryRunner();
        BeanHandler<CompanyTableModel> handler = new BeanHandler<>(CompanyTableModel.class);

        try (Connection conn = DBConfig.getDataSource().getConnection()) {
            CompanyTableModel record = runner.query(conn, sql, handler, id);
            return CompanyTableModel.toModel(record);

        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e.getMessage());
        }
    }
}
