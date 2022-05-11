package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void test() {
        Payment payment = new Payment();
        payment.setOrderId("555");
        payment.setAmount(10L);
        payment.setVirtualAccount("A1");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
