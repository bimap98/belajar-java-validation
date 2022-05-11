package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void testPaymentGroup() {
        Payment payment = new Payment();
        payment.setOrderId("A1");
        payment.setAmount(10_000L);
        payment.setCreditCard("4111111111111111");
        validateWithGroups(payment, PaymentGroup.class);
    }
}
