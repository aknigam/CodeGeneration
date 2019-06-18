
package code.gen.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import code.gen.entities.*;
import java.util.List;

public interface VendorRepository {

    Vendor update(int vendorId, Vendor vendor);

    Vendor get(int vendorId);

    Vendor create(Vendor vendor);

    void delete(int vendorId);



    void addVendorShopAddress(int vendorId, Address shopAddress);

    Address getVendorShopAddress(int vendorId);

    void deleteVendorShopAddress(int vendorId);

    void updateVendorShopAddress(int vendorId, Address shopAddress);



}

