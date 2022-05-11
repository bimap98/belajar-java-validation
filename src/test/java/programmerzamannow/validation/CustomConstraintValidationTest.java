package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;

public class CustomConstraintValidationTest extends AbstractValidatorTest{

    @Test
    void testCustomConstraint() {
        Payment payment = new Payment();
        payment.setOrderId("BIMA");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
