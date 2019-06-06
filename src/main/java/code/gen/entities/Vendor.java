package code.gen.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import code.gen.entities.Person;
import java.lang.Integer;
import code.gen.entities.Address;
import code.gen.entities.PaymentOption;
import code.gen.entities.AndroidAppDetail;
import code.gen.entities.GeoLocation;
import code.gen.entities.DeliveryTiming;
import code.gen.entities.DeliveryCriteria;
import code.gen.entities.DeliveryArea;
import code.gen.entities.TaxDetails;
import code.gen.entities.VendorStatus;
import code.gen.entities.DeliveryAgent;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Vendor {

    public Vendor() {}

    private Integer id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @Valid
    @NotNull(message="Person cannot be null")
    private Person owner;

    private Integer mobileNumber;

    private Address shopAddress;

    private List<PaymentOption> paymentOptions;

    private List<AndroidAppDetail> androidAppDetails;

    private GeoLocation geoLocation;

    private List<DeliveryTiming> deliveryTimings;

    private DeliveryCriteria deliveryCriteria;

    private List<DeliveryArea> deliveryAreas;

    private TaxDetails taxDetails;

    private VendorStatus vendorStatus;

    private List<DeliveryAgent> deliveryAgents;


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

    public Integer getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Address getShopAddress() {
        return shopAddress;
    }
    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }
    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public List<AndroidAppDetail> getAndroidAppDetails() {
        return androidAppDetails;
    }
    public void setAndroidAppDetails(List<AndroidAppDetail> androidAppDetails) {
        this.androidAppDetails = androidAppDetails;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public List<DeliveryTiming> getDeliveryTimings() {
        return deliveryTimings;
    }
    public void setDeliveryTimings(List<DeliveryTiming> deliveryTimings) {
        this.deliveryTimings = deliveryTimings;
    }

    public DeliveryCriteria getDeliveryCriteria() {
        return deliveryCriteria;
    }
    public void setDeliveryCriteria(DeliveryCriteria deliveryCriteria) {
        this.deliveryCriteria = deliveryCriteria;
    }

    public List<DeliveryArea> getDeliveryAreas() {
        return deliveryAreas;
    }
    public void setDeliveryAreas(List<DeliveryArea> deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }

    public TaxDetails getTaxDetails() {
        return taxDetails;
    }
    public void setTaxDetails(TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    public VendorStatus getVendorStatus() {
        return vendorStatus;
    }
    public void setVendorStatus(VendorStatus vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public List<DeliveryAgent> getDeliveryAgents() {
        return deliveryAgents;
    }
    public void setDeliveryAgents(List<DeliveryAgent> deliveryAgents) {
        this.deliveryAgents = deliveryAgents;
    }

}
