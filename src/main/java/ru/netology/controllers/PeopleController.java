package ru.netology.controllers;

import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.services.PeopleService;

@RestController
@RequestMapping("/persons")
public class PeopleController {

    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public ResponseEntity<String> getPersonsByCity(@RequestParam String city) {
        val personsByCity = service.getPersonsByCity(city);
        val stringBuilder = new StringBuilder("Жители города " + city + ": ");
        personsByCity.forEach((person) -> stringBuilder.append(person.getComposePersonId().getName())
                .append(", ")
                .append(person.getComposePersonId().getSurname())
                .append(", ")
                .append(person.getComposePersonId().getAge())
                .append(", ")
                .append(person.getPhoneNumber())
                .append("; "));
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.OK);
    }

    @GetMapping("younger-then-specified-age")
    public ResponseEntity<String> getPersonsWhoYoungerThanSpecifiedAge(@RequestParam int age) {
        val personsWhoYoungerThenSpecifiedAge = service.getPersonsWhoYoungerThanSpecifiedAge(age);
        val stringBuilder = new StringBuilder("Жители города, которые моложе " + age + " лет: ");
        personsWhoYoungerThenSpecifiedAge.forEach((person) -> stringBuilder.append(person.getComposePersonId().getName())
                .append(", ")
                .append(person.getComposePersonId().getSurname())
                .append(", ")
                .append(person.getComposePersonId().getAge())
                .append(", ")
                .append(person.getPhoneNumber())
                .append("; "));
        return new ResponseEntity<>(stringBuilder.toString(), HttpStatus.OK);
    }

    @GetMapping("by-name-and-surname")
    public ResponseEntity<String> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        val person = service.getPersonsByNameAndSurname(name, surname);
        return new ResponseEntity<>(person.toString(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
