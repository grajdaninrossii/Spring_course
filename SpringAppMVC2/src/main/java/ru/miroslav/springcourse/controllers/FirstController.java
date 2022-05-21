package ru.miroslav.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        System.out.println("Hello, " + name + " " + surname);
//        return "first/hello";
//    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello, " + name + " " + surname);
        // Добавляем атрибуты модели предствления из get-запроса
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatePage(@RequestParam(value = "a", required = false) Float a,
                                @RequestParam(value = "b", required = false) Float b,
                                @RequestParam(value = "action", required = false) String action,
                                Model model){


        if (a != null && b != null && action != null) {
            switch (action) {
                case "+":
                    model.addAttribute("example", "a " + action + " b = " + (a + b));
                    break;
                case "-":
                    model.addAttribute("example", "a " + action + " b = " + (a - b));
                    break;
                case "/":
                    model.addAttribute("example", "a " + action + " b = " + (a / b));
                    break;
                case "*":
                    model.addAttribute("example", "a " + action + " b = " + (a * b));
                    break;
                default:
                    model.addAttribute("example", "Wrong operation!");
                    break;
            }
        } else {
            model.addAttribute("example", "Missing parameters!");
        }

        return "first/calculator";
    }
}
