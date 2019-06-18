package code.gen.entities;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendor {

    public Vendor() {}

    private Integer id;

    private String code;

    @NotNull(message = "Vendor - name cannot be null ")
    private String name;

    private String email;

    @Valid
    @NotNull(message = "Vendor - owner cannot be null ")
    private Person owner;

    private Address shopAddress;

    private List<DeliveryTiming> deliveryTimings;

    private Map additionalProperties = new HashMap();


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Address getShopAddress() {
        return shopAddress;
    }
    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public List<DeliveryTiming> getDeliveryTimings() {
        return deliveryTimings;
    }
    public void setDeliveryTimings(List<DeliveryTiming> deliveryTimings) {
        this.deliveryTimings = deliveryTimings;
    }

    public Map getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
