package code.gen.entities;

import javax.validation.constraints.NotNull;

public class DeliveryAgent {

    public DeliveryAgent() {}

    private Integer id;

    @NotNull(message = "DeliveryAgent - firstName cannot be null ")
    private String firstName;

    @NotNull(message = "DeliveryAgent - lastName cannot be null ")
    private String lastName;


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

}
