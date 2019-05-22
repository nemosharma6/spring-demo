package com.learn.springdemo.api;

import com.learn.springdemo.model.Person;
import com.learn.springdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    @ResponseBody
    public List<Person> getPerson(){
        return personService.getPerson();
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person){
        personService.updatePerson(id, person);
    }

    @GetMapping(path = "{id}")
    @ResponseBody
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.selectPersonById(id);
    }
}
