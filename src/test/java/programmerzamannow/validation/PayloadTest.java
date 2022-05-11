package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;
import programmerzamannow.validation.payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("A1");
        payment.setAmount(10_000L);
        payment.setCreditCard("4111");

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : constraintViolations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if (payloadClass == EmailErrorPayload.class){
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println("====================");
        }

    }
}
