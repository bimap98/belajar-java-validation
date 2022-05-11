package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import programmerzamannow.validation.service.UserService;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest{

    @Test
    void testCrossParameter() throws NoSuchMethodException {

        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);

        String username = "bima";
        String password = "123";
        String retypePassword = "123";

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{
                username, password, retypePassword
        });

        for (ConstraintViolation<UserService> constraintViolation : violations) {
            System.out.println(constraintViolation.getPropertyPath());
            System.out.println(constraintViolation.getMessage());
            System.out.println("=============");
        }

    }
}
