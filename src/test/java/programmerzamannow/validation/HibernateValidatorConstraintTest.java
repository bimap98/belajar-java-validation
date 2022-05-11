package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest {

    @Test
    void testHibernateValidatorConstraintValid() {
        Payment payment = new Payment();
        payment.setAmount(100L);
        payment.setOrderId("001");
        payment.setCreditCard("411");

        validate(payment);
    }

    @Test
    void testHibernateValidatorConstraintInvalid() {
        Payment payment = new Payment();
        payment.setAmount(10_000L);
        payment.setOrderId("001");
        payment.setCreditCard("4111111111111111");

        validate(payment);
    }
}
