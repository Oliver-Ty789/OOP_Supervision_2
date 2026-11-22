package Q7;

import java.time.LocalDate;


public record Person(String firstName, String lastName, LocalDate dateOfBirth) {

    public Person(String firstName, String lastName){
        this(firstName, lastName, LocalDate.now());
    }
}
