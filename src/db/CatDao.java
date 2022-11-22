package db;

import oop.lesson3.hw.Cat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatDao implements Dao<Cat> {

    @Override
    public Cat get(int id) {
        return null;
    }

    @Override
    public Cat getCount() {
        return null;
    }

    @Override
    public List<Cat> get(String name) {
        String sql = "SELECT * FROM cats WHERE name LIKE ?";
        List<Cat> cat = new ArrayList<>();

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cat.add(new Cat(resultSet.getInt(1),
                        resultSet.getInt(3),
                        resultSet.getString(2).trim()
                ));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return cat;
    }

    @Override
    public Cat get(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Cat> getAll() {
        return null;
    }

    @Override
    public boolean add(Cat cat) {
        String sql = "INSERT INTO cats\n" +
                "\t(name, pet_owners_id)\n" +
                "\tVALUES (?, ?)";
        boolean rowInserted = false;
        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, cat.getPetName());
            statement.setInt(2, cat.getOwnerID());


            rowInserted = statement.executeUpdate() > 0;


        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();
        System.out.println("Success!");
        return rowInserted;
    }

    @Override
    public boolean update(Cat cat) {
        String sql = "UPDATE cats\n" +
                "\tSET\n" +
                "\tpet_owners_id = ?\n" +
                "WHERE cat_id = ?";

        boolean rowUpdated = false;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setInt(1, cat.getOwnerID());
            statement.setInt(2, cat.getCatID());


            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();
        System.out.println("Success!");
        return rowUpdated;
    }

    @Override
    public boolean delete(Cat object) {
        return false;
    }


}
