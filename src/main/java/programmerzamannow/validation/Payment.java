package programmerzamannow.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import programmerzamannow.validation.constraint.CheckCase;
import programmerzamannow.validation.constraint.CheckOrderId;
import programmerzamannow.validation.enums.CaseMode;
import programmerzamannow.validation.groups.CreditCardPaymentGroup;
import programmerzamannow.validation.groups.VirtualAccountPaymentGroup;
import programmerzamannow.validation.payload.EmailErrorPayload;

public class Payment {

    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "{order.id.invalid}")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "amount can not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000L, max = 10_000_000L, message = "{order.amount.range}")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card can not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "Invalid credit card",
            payload = {EmailErrorPayload.class})
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account can not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "customer can not null")
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
