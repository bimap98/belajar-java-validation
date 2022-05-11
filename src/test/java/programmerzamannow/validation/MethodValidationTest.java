package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest {

    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();
        String name = "Bima";

        Method method = Person.class.getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> constraintViolation : violations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println("====================");
        }

    }

    @Test
    void testReturnValue() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("Bima");
        person.setLastName("");

        Method method = Person.class.getMethod("fullName");

        String returnValue = person.fullName();

        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateReturnValue(person, method, returnValue);

        for (ConstraintViolation<Person> constraintViolation : violations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println("=================");
        }
    }
}
