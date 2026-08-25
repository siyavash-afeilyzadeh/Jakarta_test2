package com.black.jakarta_test2.model.da;

import com.black.jakarta_test2.model.config.ConnectionProvider;
import com.black.jakarta_test2.model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ConnectionProvider connectionProvider = new ConnectionProvider();

    public void save(Person person) throws SQLException {
        connection = connectionProvider.getConnection();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PERSONS (ID, NAME, FAMILY) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.execute();
    }

    public List<Person> findAll() throws SQLException {
        connection = connectionProvider.getConnection();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PERSONS"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            Person person = Person
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .name(resultSet.getString("NAME"))
                    .family(resultSet.getString("FAMILY"))
                    .build();
            personList.add(person);
        }
        return personList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();

    }
}
