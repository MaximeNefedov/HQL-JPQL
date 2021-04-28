package ru.netology.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.models.ComposePersonId;
import ru.netology.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleCustomRepository extends JpaRepository<Person, ComposePersonId> {
    List<Person> getByCityOfLiving(String cityOfLiving);

    List<Person> getByComposePersonIdAgeLessThan(int age, Sort sort);

    Optional<Person> getFirstByComposePersonIdNameAndComposePersonIdSurname(String name, String surname);
}
