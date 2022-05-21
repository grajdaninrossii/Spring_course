package ru.kuzin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.kuzin.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    // Пока используем список вместо бд
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db"; // желательно выносить в отдельный файл
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "devPostgres_2001";

    private static Connection connection;

    static {
        try {
            // С помощью рефлексии загружаем в оперативную память драйвер
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        // Подключение к бд
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index(){
        List<Person> people = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement(); // Создаем объект запроса к бд
            String SQL = "SELECT * FROM Person"; // Строка запроса Sql
            ResultSet resultSet = statement.executeQuery(SQL); // Выполняем запрос и созраняем рез-ты

            // В ручную достаем данные из бд и создаем Java-объекты
            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person); // Добавляем пользователя в список
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        // Если есть чел с таким id, возвращаем его, иначе null
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {

//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        // Создание и выполнение запроса на добавление
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')"; // Сделали sql запрос...
            // INSERT INTO Person VALUES(1, 'Tom', 18, 'sdfsdf')
            statement.executeUpdate(SQL);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person updatePerson) {
//        // updatePerson - новый объект, полями которого мы редактируем старый объект
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setAge(updatePerson.getAge());
//        personToBeUpdated.setEmail(personToBeUpdated.getEmail());
    }

    public void delete(int id){
//        people.removeIf(p -> p.getId() == id);
    }
}
