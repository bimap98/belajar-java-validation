package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;

import java.util.Locale;
import java.util.Set;

public class MessagesInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testI18N() {
        Locale.setDefault(new Locale("id", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("5");
        payment.setAmount(10L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {

        Payment payment = new Payment();
        payment.setOrderId("5");
        payment.setAmount(10L);

        Locale locale = new Locale("id", "ID");

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : constraintViolations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());
            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(),
                    violation.getRootBeanClass(), violation.getPropertyPath(),
                    violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true);

            System.out.println(messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale));

            System.out.println("====================");
        }
    }
}
