package ru.netology.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.models.ComposePersonId;
import ru.netology.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleCustomRepository extends JpaRepository<Person, ComposePersonId> {
    @Query("select p from persons p where p.cityOfLiving = :cityOfLiving")
    List<Person> getByCityOfLiving(String cityOfLiving);

    @Query("select p from persons p where p.composePersonId.age < :age")
    List<Person> getPersonsWhoYoungerThanSpecifiedAge(int age, Sort sort);

    @Query(value = "select * from persons where persons.name = :name and persons.surname = :surname limit 1", nativeQuery = true)
    Optional<Person> getFirstPersonByNameAndSurname(String name, String surname);
}
