package ru.netology.services;

import lombok.val;
import org.springframework.stereotype.Service;
import ru.netology.models.Person;
import ru.netology.repositories.PeopleRepository;

import java.util.List;

@Service
public class PeopleService {
    private final PeopleRepository repository;

    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        val personsByCity = repository.getPersonsByCity(city);
        if (personsByCity.isEmpty()) {
            throw new IllegalArgumentException(
                    "В городе " + city + " не найден ни один житель!"
            );
        }
        return repository.getPersonsByCity(city);
    }

    public List<Person> getPersonsWhoYoungerThanSpecifiedAge(int age) {
        val personsWhoYoungerThenSpecifiedAge = repository.getPersonsWhoYoungerThanSpecifiedAge(age);
        if (personsWhoYoungerThenSpecifiedAge.isEmpty()) {
            throw new IllegalArgumentException(
                    "Моложе указанного возраста: " + "\"" + age + "\"" + " не найден ни один житель!"
            );
        }
        return personsWhoYoungerThenSpecifiedAge;
    }

    public Person getPersonsByNameAndSurname(String name, String surname) {
        return repository.getPersonsByNameAndSurname(name, surname)
                .orElseThrow(() -> new IllegalArgumentException(
                                "Человек по имени и фамилии: " + name + " " + surname + " не найден"
                        )
                );
    }
}
