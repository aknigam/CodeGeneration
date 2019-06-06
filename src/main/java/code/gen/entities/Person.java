package code.gen.entities;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;
import java.lang.String;

public class Person {

    public Person() {}

    private Integer id;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    private String middleName;

    @NotNull(message = "Person mobile number cannot be null")
    private Integer mobileNumber;

    @NotNull(message = "Email cannot be null")
    private String email;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
