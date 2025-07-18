package mini.infrastracture.repository.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import mini.config.db.mysql.DBConfig;
import mini.domain.model.Simple;
import mini.domain.repository.SimpleRepository;

@RequestScoped
public class SimpleRepositoryImpl implements SimpleRepository {

    @Override
    public List<Simple> findAll() throws SQLException {

        String sql = "SELECT id, name FROM company";
        try (Connection conn = DBConfig.getDataSource().getConnection()) {
            QueryRunner runner = new QueryRunner();
            
            List<SimpleTableModel> res = runner.query(conn, sql, new BeanListHandler<>(SimpleTableModel.class));
            return SimpleTableModel.toModels(res);
        }
    }

    @Override
    public Simple getById(Integer id) {

        String sql = "SELECT id, name FROM company where id = ?";
        QueryRunner runner = new QueryRunner();
        BeanHandler<SimpleTableModel> handler = new BeanHandler<>(SimpleTableModel.class);

        try (Connection conn = DBConfig.getDataSource().getConnection()) {
            SimpleTableModel model = runner.query(conn, sql, handler, id);
            return SimpleTableModel.toModel(model);

        } catch(SQLException e){
            throw new RuntimeException();
        }
    }
}