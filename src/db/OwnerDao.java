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
    public Pet.PetOwner getCount() {
        return null;
    }

    @Override
    public List<Pet.PetOwner> get(String name) {
        return null;
    }


    public Pet.PetOwner get(Date firstDate, Date secondDate) {

        return null;
    }

    @Override
    public List<Pet.PetOwner> getAll() {
        return null;
    }


    public List<Pet.PetOwner> getAll(java.sql.Date firstDate, java.sql.Date secondDate) {

        List<Pet.PetOwner> petOwner = new ArrayList<>();

        String sql = "SELECT * FROM owners WHERE date_registration BETWEEN ? AND ?";

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setDate(1, (java.sql.Date) firstDate);
            statement.setDate(2, (java.sql.Date) secondDate);

            ResultSet resultSet = statement.executeQuery();

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
                "\tVALUES (?, ?, SYSDATE())";

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            statement.setString(1, petOwner.getOwnerName());
            statement.setString(2, petOwner.getOwnerEmail());

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


}
