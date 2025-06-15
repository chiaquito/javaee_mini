package mini.infrastracture.repository.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import mini.config.application.javaee.Context;
import mini.config.db.mysql.DBConfig;
import mini.domain.SystemErrException;
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

    @Override
    public void create(Context ctx, String name, String establishedDate, Integer createUserId) {

        String sql = "INSERT INTO company (name, established_date, created_user_id, updated_user_id, created_at, updated_at, version) VALUES (?, ?, ?, ?, ?, ? ,?);";
        QueryRunner runner = new QueryRunner();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            runner.insert(ctx.getConnection(), sql, new ScalarHandler<>(), name, establishedDate, createUserId, createUserId, timestamp, timestamp, 1);
        } catch(SQLException e){
            throw new SystemErrException(e.getMessage(), e);
        }
    }
}
