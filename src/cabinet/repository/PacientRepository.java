package cabinet.repository;

import cabinet.Pacient;
import cabinet.config.dbSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class PacientRepository {

    // creare tabela

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS pacienti " + "(id int PRIMARY KEY AUTO_INCREMENT" +
                ", nume varchar(100), cnp varchar(100), int varsta, int sex)";

        Connection connection = dbSQL.getDatabaseConnection();

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //inserare pacient

    public void insertPacient(Pacient pacient){

        String insPacientSql = "INSERT INTO pacienti(nume, cnp, sex,varsta ) VALUES (?,?, ?,?)";

        Connection connection = dbSQL.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insPacientSql);
            preparedStatement.setString(1, pacient.getNume());
            preparedStatement.setString(2, pacient.getCnp());
            preparedStatement.setInt(3, pacient.getSex());
            preparedStatement.setInt(4, pacient.getVarsta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // cautarea unui pacient dupa id

    public Pacient getPacientById (int id) {
        String selectSql = "SELECT * FROM pacienti WHERE id=?";

        Connection connection = dbSQL.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToPacient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Pacient mapToPacient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Pacient(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), new String[]{});
        }

        return null;
    }


    // modificarea varstei unui pacient


    public void updatePacientVarsta(int varsta, int id) {

        String updateNameSql = "UPDATE pacienti SET varsta=? WHERE id=?";

        Connection connection = dbSQL.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, varsta);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePacient(int id){
        String deleteSql = "delete from pacienti WHERE id=?";

        Connection connection = dbSQL.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
