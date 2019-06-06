
package code.gen.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import code.gen.entities.*;
import java.util.List;

public interface DeliveryAgentRepository {

    DeliveryAgent update(int deliveryAgentId, DeliveryAgent deliveryAgent);

    DeliveryAgent get(int deliveryAgentId);

    DeliveryAgent create(DeliveryAgent deliveryAgent);

    void delete(int deliveryAgentId);



}

