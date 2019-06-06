
package code.gen.written.repository;

import code.gen.written.entities.DeliveryAgent;
import code.gen.written.entities.Person;
import code.gen.written.repository.mapper.DeliveryAgentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import code.gen.entities.*;

//@Repository
public class DeliveryAgentRepositoryImpl implements DeliveryAgentRepository {

//    @Autowired
    private DeliveryAgentMapper deliveryAgentMapper;

    @Override
    public DeliveryAgent update(int deliveryAgentId, DeliveryAgent deliveryAgent) {
        return deliveryAgentMapper.update(deliveryAgentId, deliveryAgent);
    }

    @Override
    public DeliveryAgent get(int deliveryAgentId) {
        return deliveryAgentMapper.get(deliveryAgentId);
    }

    @Override
    public DeliveryAgent create(DeliveryAgent deliveryAgent) {
        deliveryAgentMapper.create(deliveryAgent);
        return deliveryAgent;
    }

    @Override
    public void delete(int deliveryAgentId) {
        deliveryAgentMapper.delete(deliveryAgentId);
    }

    @Override
    public int addDeliveryAgentPerson(int deliveryAgentId, Person person) {
        return 0;
    }

    @Override
    public Person getDeliveryAgentPerson(int deliveryAgentId) {
        return null;
    }

    @Override
    public void deleteDeliveryAgentPerson(int deliveryAgentId) {

    }

    @Override
    public void updateDeliveryAgentPerson(int deliveryAgentId, Person person) {

    }
}
