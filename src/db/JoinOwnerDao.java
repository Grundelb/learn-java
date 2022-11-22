package db;

import oop.lesson3.hw.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JoinOwnerDao implements Dao<JoinOwnerDao> {

    private String ownerName;
    private String catName;
    private String dogName;

    @Override
    public String toString() {
        return "JoinOwnerDao{" +
                "ownerName='" + ownerName + '\'' +
                ", catName='" + catName + '\'' +
                ", dogName='" + dogName + '\'' +
                '}';
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDogName() {
        return dogName;
    }

    public JoinOwnerDao(String ownerName, String catName, String dogName) {
        this.ownerName = ownerName;
        this.catName = catName;
        this.dogName = dogName;
    }

    public JoinOwnerDao(String ownerName) {
        this(ownerName, null, null);
    }


    public JoinOwnerDao() {
    }

    @Override
    public JoinOwnerDao get(int id) {
        return null;
    }

    @Override
    public JoinOwnerDao getCount() {
        return null;
    }

    @Override
    public List<JoinOwnerDao> get(String name) {
        return null;
    }

    @Override
    public JoinOwnerDao get(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<JoinOwnerDao> getAll() {
        List<JoinOwnerDao> joinOwnerDaos = new ArrayList<>();

        try (Statement statement = Connection.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT " +
                    "owners.name as 'Owner name', cats.name as 'Cat name', dogs.name as 'Dog name'\n" +
                    "FROM owners\n" +
                    "\tLEFT JOIN cats ON\n" +
                    "\towners.owner_id = cats.pet_owners_id\n" +
                    "\tLEFT JOIN dogs ON\n" +
                    "\towners.owner_id = dogs.pet_owner_id\n" +
                    "\tORDER BY\n" +
                    "\towners.name");

            while (resultSet.next()) {
                joinOwnerDaos.add(new JoinOwnerDao(resultSet.getString(1).trim(),
                        resultSet.getString(2).trim().toString(),
                        resultSet.getString(3).toString()));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return joinOwnerDaos;
    }

    @Override
    public boolean add(JoinOwnerDao object) {
        return false;
    }

    @Override
    public boolean update(JoinOwnerDao object) {
        return false;
    }

    @Override
    public boolean delete(JoinOwnerDao object) {
        return false;
    }
}
