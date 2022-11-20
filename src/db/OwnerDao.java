package db;

import oop.lesson3.hw.*;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class OwnerDao implements Dao<Pet.PetOwner> {

    @Override
    public Pet.PetOwner get(int id) {
        return null;
    }

    @Override
    public List<Pet.PetOwner> get(String name) {
        return null;
    }


    @Override
    public Pet.PetOwner get(Date firstDate, Date secondDate) {
        String sql = "SELECT * FROM owners WHERE date_registration BETWEEN ? AND ?";
        Pet.PetOwner petOwner = null;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setDate(1, (java.sql.Date) firstDate);
            statement.setDate(2, (java.sql.Date) secondDate);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                petOwner = new Pet.PetOwner(resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getDate(4));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return petOwner;
    }

    @Override
    public List<Pet.PetOwner> getAll() {
        List<Pet.PetOwner> petOwner = new ArrayList<>();

        try (Statement statement = Connection.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM owners");

            while (resultSet.next()) {
                petOwner.add(new Pet.PetOwner(resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getDate(4)));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return petOwner;
    }


    @Override
    public boolean add(Pet.PetOwner petOwner) {

        String sql = "INSERT INTO owners\n" +
                "\t(name, email, date_registration)\n" +
                "\tVALUES (?, ?, ?)";

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, petOwner.getOwnerName());
            statement.setString(2, petOwner.getOwnerEmail());
            statement.setDate(3, (java.sql.Date) petOwner.getRegistrationDate());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();
        return false;
    }

    @Override
    public boolean update(Pet.PetOwner object) {
        return false;
    }

    @Override
    public boolean delete(Pet.PetOwner object) {
        return false;
    }

    public void getMin() {

        String sql = "SELECT MIN(owner_id) as 'ID number',name FROM owners GROUP BY owner_id, name";
        Pet.PetOwner petOwner = null;

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            System.out.println("Min " + "     " +  " Name");
            while (resultSet.next()) {
                int minValue= resultSet.getInt(1);
                String name = resultSet.getString(2).trim();
                System.out.printf("%-10d%-32s\n", minValue, name);
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

    }


}
