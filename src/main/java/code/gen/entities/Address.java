package code.gen.entities;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.Integer;
import java.lang.String;
import java.lang.String;

public class Address {

    public Address() {}

    private Integer id;

    private String line1;

    private String line2;

    private String area;

    private String city;

    private Integer pinCode;

    private String State;

    private String Country;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPinCode() {
        return pinCode;
    }
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return State;
    }
    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }
    public void setCountry(String Country) {
        this.Country = Country;
    }

}
