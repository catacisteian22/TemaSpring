package map.project.demo.repository;

import map.project.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;

@Repository
public interface AutorRepo extends JpaRepository<Autor, Long> {


//    private static AutorRepo instance;
//    private List<Autor> autorList;
//    private Connection connection; // Add a connection field

//    private AutorRepo(List<Autor> autorList) {
//        this.autorList = autorList;
//        this.connection = establishDatabaseConnection();
//    }

//    private Connection establishDatabaseConnection() {
//        try {
//            Class.forName("jdbc:mysql://localhost:3306/bookstore");
//            String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
//            String username = "root";
//            String password = "Cata22";
//            return DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to establish a database connection");
//        }
//    }
//
//    public void add(Autor autor) {
//        String sql = "INSERT INTO autor (id_autor, name, other_columns) VALUES (?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, autor.getIdAutor());
//            statement.setString(2, autor.getName());
//            // set other parameters
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public Autor update(Long id, Autor new_entity) {
////        return null;
//        return new_entity;
//    }
//
//    @Override
//    public List<Autor> getAll() {
//        return null;
//    }
//
//    public boolean getById(Long id) {
//        String sql = "SELECT * FROM autor_table WHERE id_autor = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            return resultSet.next(); // If there is a matching record, return true
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public Autor getByIdentifier(Long id) {
//        for (Autor autor : autorList) {
//            if (autor.getIdAutor().equals(id)) {
//                return autor;
//            }
//        }
//        return null;
//    }
//    // ... other methods
//
//    public void closeConnection() {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}