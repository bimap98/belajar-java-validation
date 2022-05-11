package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;

public class ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition() {
        Payment payment = new Payment();
        payment.setOrderId("12345abcd");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
