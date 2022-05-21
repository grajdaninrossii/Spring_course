package ru.kuzin.springcourse.dao;


import org.springframework.jdbc.core.RowMapper;
import ru.kuzin.springcourse.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

// RowMapper - объект, отображающий строки из таблицы в сущность,
// В данном слуае в объекты класса Person
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {

        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}
