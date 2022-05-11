package programmerzamannow.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    private List<@NotBlank(message = "hobbies can not blank") String> hobbies;

    @Size(max = 20, message = "firstname max length must 20 characters")
    @NotBlank(message = "firstName can not blank")
    private String firstName;

    @Size(max = 20, message = "lastname max length must 20 characters")
    @NotBlank(message = "lastName can not blank")
    private String lastName;

    @NotNull(message = "address can not null")
    @Valid
    private Address address;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Valid
    public Person() {
    }

    @Valid
    public Person(@NotBlank(message = "firstname can not blank") String firstName,
                  @NotBlank(message = "lastname can not blank") String lastName,
                  @NotNull(message = "address can not null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "name must not blank") String name){
        System.out.println("Hi " + name + " my name is " + this.firstName);
    }

    @NotBlank(message = "fullName can not blank")
    public String fullName(){
        return firstName + " " + lastName;
    }
}
