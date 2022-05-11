package programmerzamannow.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import programmerzamannow.validation.enums.CaseMode;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;
import programmerzamannow.validation.groups.VirtualAccountPaymentGroup;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        message = "{order.id.notblank}")
@Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        min = 10, max = 100, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({FIELD})
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {

    String message() default "invalid order id";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
