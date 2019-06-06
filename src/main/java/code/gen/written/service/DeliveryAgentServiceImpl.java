
package code.gen.written.service;

import code.gen.entities.*;
import code.gen.written.repository.DeliveryAgentRepository;

import code.gen.written.entities.DeliveryAgent;
import code.gen.written.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {

//    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;


    @Override
    public DeliveryAgent update(int deliveryAgentId, DeliveryAgent deliveryAgent) {
        return deliveryAgentRepository.update(deliveryAgentId, deliveryAgent);
    }

    @Override
    public DeliveryAgent get(int deliveryAgentId) {
        return deliveryAgentRepository.get(deliveryAgentId);
    }

    @Override
    public DeliveryAgent create(DeliveryAgent deliveryAgent) {
        return deliveryAgentRepository.create(deliveryAgent);
    }

    @Override
    public void delete(int deliveryAgentId) {
        deliveryAgentRepository.delete(deliveryAgentId);
    }







//    ONE TO ONE starts
    @Override
    public int addDeliveryAgentPerson(int deliveryAgentId, Person person) {
        int personId =   deliveryAgentRepository.addDeliveryAgentPerson(deliveryAgentId, person);
    return personId;
    }

    @Override
    public Person getDeliveryAgentPerson(int deliveryAgentId) {
        return deliveryAgentRepository.getDeliveryAgentPerson(deliveryAgentId);
    }

    @Override
    public void deleteDeliveryAgentPerson(int deliveryAgentId) {
        deliveryAgentRepository.deleteDeliveryAgentPerson(deliveryAgentId);
    }

    @Override
    public void updateDeliveryAgentPerson(int deliveryAgentId, Person person) {
        deliveryAgentRepository.updateDeliveryAgentPerson(deliveryAgentId, person);
    }



}

