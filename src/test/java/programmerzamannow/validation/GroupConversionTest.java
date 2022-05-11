package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;

public class GroupConversionTest extends AbstractValidatorTest{

    @Test
    void testGroupConvert() {
        Payment payment = new Payment();
        payment.setOrderId("A1");
        payment.setAmount(10_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
