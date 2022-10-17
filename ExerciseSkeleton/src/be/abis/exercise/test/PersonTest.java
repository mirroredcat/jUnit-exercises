package be.abis.exercise.test;

import be.abis.exercise.exception.PersonShouldBeAdultException;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    Person p;
    Person p2;

    @BeforeEach
    void setUp() {
        p = new Person(1, "John", "Doe", LocalDate.of(1980,2,12));
        p2 = new Person(2, "Alice", "Still", LocalDate.of(2016, 2,2));
    }

    @Test
    @Order(1)
    void person1ShouldBe42YearsOld() throws PersonShouldBeAdultException {
        assertThat(p.calculateAge(),equalTo(42));
    }

    @Test
    @Order(3)
    void toStringSentenceStartsWithPerson(){
        assertThat(p.toString(), startsWith("Person"));
    }

    @Test
    @Order(2)
    void personIsNotAdultThrowsException() {
        assertThrows(PersonShouldBeAdultException.class, () -> p2.calculateAge());
    }
}
