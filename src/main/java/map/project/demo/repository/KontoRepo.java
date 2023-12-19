package map.project.demo.repository;

import map.project.demo.model.Konto;
import map.project.demo.model.Verlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KontoRepo extends JpaRepository<Konto, Long> {


//
//    private List<Konto> kontoList;
//    private Connection connection;
//    public KontoRepo(List<Konto> kontoList, Connection connection) {
//        this.kontoList = kontoList;
//        this.connection = establishDatabaseConnection();
//    }
//
//    public KontoRepo() {
//    }
//
//    private Connection establishDatabaseConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String jdbcUrl = "jdbc:mysql://localhost:3306/bookstore";
//            String username = "root";
//            String password = "Cata22";
//            return DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to establish a database connection");
//        }
//    }
//    public KontoRepo(List<Konto> kontoList) {
//    }
//
//    public void add(Konto k) {
//        String sql = "INSERT INTO konto (idKonto, username, password, joinDatum, typ) VALUES (? ,?, ?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, k.getIdKonto());
//            statement.setString(2, k.getUsername());
//            statement.setString(3, k.getPassword());
//            statement.setObject(4, k.getJoinDatum());
//            statement.setString(5, k.getTyp());
//
//            int affectedRows = statement.executeUpdate();
//            if (affectedRows > 0) {
//                kontoList.add(k);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the exception appropriately, e.g., log it or throw a custom exception
//        }
//    }
//
//    public boolean getById(Long idKonto) {
//        String sql = "SELECT * FROM konto WHERE idKonto = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, idKonto);
//            ResultSet resultSet = statement.executeQuery();
//
//            return resultSet.next();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the exception appropriately, e.g., log it or throw a custom exception
//            return false;
//        }
//    }
//
//    public Konto getByIdentifier(Long id) {
//        for (Konto Konto : kontoList) {
//            if (Konto.getIdKonto().equals(id)) {
//                return Konto;
//            }
//        }
//        return null;
//    }
//
//    public void delete(Long idKonto) {
//        String sql = "DELETE FROM konto WHERE idKonto = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setLong(1, idKonto);
//            int affectedRows = statement.executeUpdate();
//
//            if (affectedRows > 0) {
//                kontoList.removeIf(k -> k.getIdKonto().equals(idKonto));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the exception appropriately, e.g., log it or throw a custom exception
//        }
//    }
//
//    public Konto update(Long idKonto, Konto newKonto) {
//        String sql = "UPDATE konto SET username = ?, password = ?, joinDatum = ?, typ = ? WHERE idKonto = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, newKonto.getUsername());
//            statement.setString(2, newKonto.getPassword());
//            statement.setObject(3, newKonto.getJoinDatum());
//            statement.setString(4, newKonto.getTyp());
//            statement.setLong(5, idKonto);
//
//            int affectedRows = statement.executeUpdate();
//            if (affectedRows > 0) {
//                for (int i = 0; i < kontoList.size(); i++) {
//                    Konto k = kontoList.get(i);
//                    if (k.getIdKonto().equals(idKonto)) {
//                        kontoList.set(i, newKonto);
//                        return newKonto;
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the exception appropriately, e.g., log it or throw a custom exception
//        }
//        return null;
//    }
//
//    public List<Konto> getAll() {
//        // Implement this method based on your specific use case
//        // You might need to retrieve all records from the database and populate the lis
//        String sql = "SELECT * FROM konto";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                Long idKonto=resultSet.getLong("idKonto");
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//                LocalDateTime joinDatum = resultSet.getObject("joinDatum", LocalDateTime.class);
//                String typ = resultSet.getString("typ");
//
//                Konto konto = new Konto(idKonto,username, password, joinDatum, typ);
//                konto.setIdKonto(resultSet.getLong("idKonto"));
//                kontoList.add(konto);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the exception appropriately, e.g., log it or throw a custom exception
//        }
//        return kontoList;
//    }
}
