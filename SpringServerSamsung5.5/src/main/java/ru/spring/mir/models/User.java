package ru.spring.mir.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data // генерация всех служебных методов, заменяет сразу команды @ToString, @EqualsAndHashCode,
      // Getter, Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String lastname;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Classname should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String classname;
}
