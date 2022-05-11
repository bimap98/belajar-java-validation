package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest{

    @Test
    void testClassLevel() {
        Register register = new Register();
        register.setUsername("bima");
        register.setPassword("123");
        register.setRetypePassword("12345");

        validate(register);
    }
}
