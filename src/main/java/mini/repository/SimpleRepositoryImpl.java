package mini.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

import mini.model.Simple; 

@RequestScoped
public class SimpleRepositoryImpl implements SimpleRepository {

    @Override
    public List<Simple> findAll() throws SQLException {
        List<Simple> res = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/db?useSSL=false&serverTimezone=Asia/Tokyo";
        String dbUser = "root";
        String dbPassword = "password";

        String sql = "SELECT id, name FROM company";
        try (
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
                Simple s = new Simple();
                s.setId(id);
                s.setName(name);
                res.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return res;
    }
}