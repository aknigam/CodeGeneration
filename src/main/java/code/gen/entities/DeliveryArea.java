package code.gen.entities;

import javax.validation.constraints.NotNull;

public class DeliveryArea {

    public DeliveryArea() {}

    private Integer id;

    @NotNull(message = "DeliveryArea - pinCode cannot be null ")
    private Integer pinCode;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPinCode() {
        return pinCode;
    }
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

}
