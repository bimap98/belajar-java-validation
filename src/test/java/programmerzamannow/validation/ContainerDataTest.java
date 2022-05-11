package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest{

    @Test
    void testContainerData() {
        Person person = new Person();
        person.setFirstName("Bima");
        person.setLastName("Putra");

        person.setAddress(new Address());
        person.getAddress().setCity("Surabaya");
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setStreet("Tandes");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add(" ");
        person.getHobbies().add("Programming");

        validate(person);

    }
}
