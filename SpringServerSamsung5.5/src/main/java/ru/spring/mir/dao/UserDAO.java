package ru.spring.mir.dao;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.spring.mir.Application;
import ru.spring.mir.models.User;

import java.util.List;

@Component
public class UserDAO {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final JdbcTemplate jdbcTemplate;

    // Внедрение зависимости бина шаблонизотора через конструктор
    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        createDB();
    }

    // Создаем таблицу, если таковой не было
    public void createDB (){
        log.info("Creating tables");

//        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
//        System.out.println("ALLO RABOTAY))");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users(" +
                "id SERIAL, name VARCHAR(255), lastname VARCHAR(255), classname VARCHAR(255))");
    }

    // Получить список пользователей
    public List<User> show () {
        System.out.println(jdbcTemplate.query("SELECT * FROM Users", new UserMapper()));
        return jdbcTemplate.query("SELECT * FROM Users", new UserMapper());
    }

    // Добавить пользователя
    public void save(String name,
                     String lastname,
                     String classname){

        jdbcTemplate.update("INSERT INTO Users (name, lastname, classname) VALUES(?, ?, ?)",
                name, lastname, classname);
    }
}
