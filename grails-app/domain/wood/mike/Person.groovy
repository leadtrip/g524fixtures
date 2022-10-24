package wood.mike

import java.time.LocalDate

class Person {

    String forename
    String surname
    LocalDate dob

    static hasMany = [pets: Pet, addresses: Address]

    static constraints = {
        forename nullable: false
        surname nullable: false
        dob nullable: false
    }


    @Override
    String toString() {
        return "Person{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", pets=" + pets +
                ", addresses=" + addresses +
                '}';
    }
}
