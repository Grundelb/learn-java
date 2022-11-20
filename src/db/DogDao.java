package db;

import oop.lesson3.hw.Cat;
import oop.lesson3.hw.Dog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DogDao implements Dao<Dog> {
    @Override
    public Dog get(int id) {
        return null;
    }

    @Override
    public List<Dog> get(String name) {
        return null;
    }

    @Override
    public Dog get(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Dog> getAll() {
        return null;
    }

    @Override
    public boolean add(Dog dog) {
        String sql = "INSERT INTO dogs\n" +
                "\t(name, pet_owner_id)\n" +
                "\tVALUES (?, ?)";
        boolean rowInserted = false;
        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, dog.getPetName());
            statement.setInt(2, dog.getOwnerDogID());


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
    public boolean update(Dog object) {
        return false;
    }

    @Override
    public boolean delete(Dog dog) {
        String sql = "DELETE FROM dogs\n" +
                "\tWHERE dog_id=?";
        boolean rowDeleted = false;
        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setInt(1, dog.getDogID());


            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return rowDeleted;
    }

    public boolean delete() {
        String sql = "DELETE FROM dogs";
        boolean rowDeleted = false;
        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {


            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();
        return rowDeleted;
    }

    public Dog get(int firstID, int secondID) {
        String sql = "SELECT * \n" +
                "FROM dogs\n" +
                "\tWHERE pet_owner_id IN (?,?)";
        Dog dog = null;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setInt(1, firstID);
            statement.setInt(2, secondID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                dog = new Dog(resultSet.getInt(1),
                        resultSet.getInt(3),
                        resultSet.getString(2).trim()
                );
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return dog;
    }


}
