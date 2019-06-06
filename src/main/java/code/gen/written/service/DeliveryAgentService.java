
package code.gen.written.service;

import code.gen.entities.*;
import code.gen.written.entities.DeliveryAgent;
import code.gen.written.entities.Person;


public interface DeliveryAgentService {

    DeliveryAgent update(int deliveryAgentId, DeliveryAgent deliveryAgent);

    DeliveryAgent get(int deliveryAgentId);

    DeliveryAgent create(DeliveryAgent deliveryAgent);

    void delete(int deliveryAgentId);





    int addDeliveryAgentPerson(int deliveryAgentId, Person person);

    Person getDeliveryAgentPerson(int deliveryAgentId);

    void deleteDeliveryAgentPerson(int deliveryAgentId);

    void updateDeliveryAgentPerson(int deliveryAgentId, Person person);




}


