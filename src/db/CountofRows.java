package db;

import oop.lesson3.hw.Pet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CountofRows implements Dao<CountofRows> {

    private String name;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountofRows{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public CountofRows(int count, String name) {
        this.name = name;
        this.count = count;
    }

    public CountofRows(int count) {
        this.count = count;
    }

    public CountofRows() {
    }

    @Override
    public CountofRows get(int id) {
        return null;
    }

    @Override
    public CountofRows getCount() {
        CountofRows cr = null;
        try (Statement statement = Connection.getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*)\n" +
                    "\t+(SELECT COUNT(*) FROM dogs)\n" +
                    "\t+(SELECT COUNT(*) FROM cats)\n" +
                    "FROM owners");

            while (resultSet.next()) {
                cr = new CountofRows(resultSet.getInt(1));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();

        return cr;
    }

    @Override
    public List<CountofRows> get(String name) {
        return null;
    }

    @Override
    public CountofRows get(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<CountofRows> getAll() {

        String sql = "SELECT MIN(owner_id) as 'ID number',name FROM owners GROUP BY owner_id, name";
        List<CountofRows> cr = new ArrayList<>();

        try (PreparedStatement statement = Connection.getConnection().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cr.add(new CountofRows(resultSet.getInt(1),
                        resultSet.getString(2).trim()
                ));
            }
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Exception during the statement execution "
                    + e);
        }
        Connection.close();
        return cr;
    }


    @Override
    public boolean add(CountofRows object) {
        return false;
    }

    @Override
    public boolean update(CountofRows object) {
        return false;
    }

    @Override
    public boolean delete(CountofRows object) {
        return false;
    }
}
