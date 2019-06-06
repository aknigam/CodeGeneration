
package code.gen.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import code.gen.repository.mapper.DeliveryAgentMapper;
import code.gen.entities.*;
import java.util.List;

@Repository
public class DeliveryAgentRepositoryImpl implements DeliveryAgentRepository {

    @Autowired
    private DeliveryAgentMapper deliveryAgentMapper;

    @Override
    public DeliveryAgent update(int deliveryAgentId, DeliveryAgent deliveryAgent) {
        try {
            return deliveryAgentMapper.update(deliveryAgentId, deliveryAgent);
        }
        catch (DataIntegrityViolationException dive) {
        //             this exception occurs if the length of the field is more than required.
            throw dive;
        }
        // TODO: 26/05/19 always add this catch block in the dao methods
        catch (DataAccessException e ) {
            throw e;
        }
    }

    @Override
    public DeliveryAgent get(int deliveryAgentId) {
        return deliveryAgentMapper.get(deliveryAgentId);
    }

    @Override
    public DeliveryAgent create(DeliveryAgent deliveryAgent) {
        try {
            deliveryAgentMapper.create(deliveryAgent);
        }
        catch (DuplicateKeyException dke) {
            throw dke;
        }
        catch (DataIntegrityViolationException dive) {
        //             this exception occurs if the length of the field is more than required.
            throw dive;
        }
        // TODO: 26/05/19 always add this catch block in the dao methods
        catch (DataAccessException e ) {
            throw e;
        }
        return deliveryAgent;
    }

    @Override
    public void delete(int deliveryAgentId) {

        DeliveryAgent deliveryAgent = deliveryAgentMapper.get(deliveryAgentId);
        // call all the unlink operations
        deliveryAgentMapper.delete(deliveryAgentId);
    }

}


