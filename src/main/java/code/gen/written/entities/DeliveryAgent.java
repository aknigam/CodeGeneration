package code.gen.written.entities;

import java.lang.Integer;

public class DeliveryAgent {

    public DeliveryAgent() {}

    private Integer id;

    private Person person;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

}
