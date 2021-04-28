package ru.netology.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.netology.models.Person;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PeopleRepository {
    private final PeopleCustomRepository repository;

    public PeopleRepository(PeopleCustomRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getByCityOfLiving(city);
    }

    public List<Person> getPersonsWhoYoungerThanSpecifiedAge(int age) {
        return repository.getPersonsWhoYoungerThanSpecifiedAge(age, Sort.by("composePersonId.age").ascending());
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return repository.getFirstPersonByNameAndSurname(name, surname);
    }
}
