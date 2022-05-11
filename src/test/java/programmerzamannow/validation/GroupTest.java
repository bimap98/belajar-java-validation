package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;
import programmerzamannow.validation.groups.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest{

    @Test
    void testCreditCard() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(20_000L);
        payment.setCreditCard("123");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccount() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
