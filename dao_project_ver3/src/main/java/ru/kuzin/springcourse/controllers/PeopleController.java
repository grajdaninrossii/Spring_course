package ru.kuzin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kuzin.springcourse.dao.PersonDAO;
import ru.kuzin.springcourse.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model){
        // Получим всех людей из DAO и передадим их в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model){
        // Получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

//    @GetMapping("/new")
//    public String newPerosn(Model model){
//        model.addAttribute("person", new Person());
//        return "people/new";
//    }

    // ModelAttribute создасть объект класса Person и положит его сама в модель
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){

        // Проверка наличия ошибок
        if (bindingResult.hasErrors()){
            return "people/new"; // Возвращаем ту же самую форму
        }

        // Сохранить объект в "бд"
        personDAO.save(person);

        // Используем редирект (переход на другую страницу)
        return "redirect:/people";
    }

    // Редактирование person
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    // Patch-метод редактирования
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id){

        // Проверка наличия ошибок
        if (bindingResult.hasErrors()){
            return "people/edit"; // Возвращаем ту же самую форму
        }

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
