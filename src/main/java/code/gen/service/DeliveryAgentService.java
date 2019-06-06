
package code.gen.service;

import code.gen.entities.*;
import java.util.List;


public interface DeliveryAgentService {

    DeliveryAgent update(int deliveryAgentId, DeliveryAgent deliveryAgent);

    DeliveryAgent get(int deliveryAgentId);

    DeliveryAgent create(DeliveryAgent deliveryAgent);

    void delete(int deliveryAgentId);








}


