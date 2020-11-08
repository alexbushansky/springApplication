package com.bushanskiy.springapplication.controllers;

import com.bushanskiy.springapplication.dao.PersonDao;
import com.bushanskiy.springapplication.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
public class PersonController {

    private PersonDao personDao;

    @Autowired
    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }


    @GetMapping("/show-persons")
    public ModelAndView listContact(ModelAndView model){

        List<Person> persons= personDao.getAllPersons();
        model.addObject("listPerson", persons);
        model.setViewName("person");
        return model;
    }


    @PostMapping("/create-person")
    public RedirectView createPerson(@RequestParam String firstName, @RequestParam String lastName)
    {
        personDao.addNewPerson(new Person(firstName,lastName));

        return new RedirectView("/show-persons");

    }

    @PostMapping("/update-person")
    public RedirectView updatePerson(@RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam int id)
    {

        personDao.updatePerson(id,firstName,lastName);
        return new RedirectView("/show-persons");
    }

    @GetMapping("/update-person/{personId}")
    public ModelAndView updatePersonPage(@PathVariable int personId, ModelAndView model)
    {
        model.addObject("personId", personId);
        model.setViewName("update-person");
        return model;
    }



    @PostMapping("/delete-person")
    public RedirectView deletePerson(@RequestParam int id)
    {
        personDao.deletePerson(id);
        return new RedirectView("/show-persons");
    }
}
