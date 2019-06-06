
package code.gen.service;

import code.gen.entities.*;
import code.gen.service.DeliveryAgentService;
import code.gen.repository.DeliveryAgentRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {

    @Autowired
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







}

