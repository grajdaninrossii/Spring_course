package ru.spring.mir.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.spring.mir.dao.UserDAO;
import ru.spring.mir.models.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UsersController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public ResponseEntity show() {

        // получим всех людей из DAO и передадим их в представление
        List<User> users = userDAO.show();
        if (!users.isEmpty()){
            return new ResponseEntity(users, HttpStatus.OK);
        }

        return new ResponseEntity("EMPTY_LIST", HttpStatus.NOT_FOUND);
    }

    @PatchMapping
    public ResponseEntity updateUser(@ModelAttribute("user") @Valid User user,
                                     BindingResult bindingResult){

//        System.out.println(user.getName() + " " + user.getLastname() + " " + user.getClassname());

        if (bindingResult.hasErrors()){
            System.out.println("NOVAlid data");
            return new ResponseEntity("BAD", HttpStatus.UNAUTHORIZED);
        }

        userDAO.save(user.getName(), user.getLastname(), user.getClassname());

        return new ResponseEntity("GOOD", HttpStatus.OK);
    }

}
