
package code.gen.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import code.gen.repository.mapper.VendorMapper;
import code.gen.entities.*;
import java.util.List;

@Repository
public class VendorRepositoryImpl implements VendorRepository {

    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public Vendor update(int vendorId, Vendor vendor) {
        try {
            vendor.setId(vendorId);
            vendorMapper.update(vendorId, vendor);

            upsertVendorOwner(vendorId, vendor.getOwner());
            return vendorMapper.get(vendorId);
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

    public void upsertVendorOwner(int vendorId, Person owner) {
        if(owner != null) {
            if(owner.getId() == null) {
                vendorMapper.addVendorOwner(owner);
                vendorMapper.linkVendorOwner(vendorId, owner.getId());
            }
            else {
                vendorMapper.updateVendorOwner(owner);
            }
        }
    }

    @Override
    public Vendor get(int vendorId) {
        return vendorMapper.get(vendorId);
    }

    @Override
    public Vendor create(Vendor vendor) {
        try {
            vendorMapper.addVendorOwner(vendor.getOwner());
            vendorMapper.create(vendor);
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
        return vendor;
    }

    @Override
    public void delete(int vendorId) {

        Vendor vendor = vendorMapper.get(vendorId);
        // call all the unlink operations
        vendorMapper.unLinkVendorOwner(vendorId);
        vendorMapper.deleteVendorOwner(vendorId);

        vendorMapper.unLinkVendorShopAddress(vendorId);

        vendorMapper.delete(vendorId);
    }



    public void addVendorShopAddress(int vendorId, Address shopAddress) {
        vendorMapper.addVendorShopAddress(shopAddress);
        int id = shopAddress.getId();
        vendorMapper.linkVendorShopAddress(vendorId,  id);
    }

    public Address getVendorShopAddress(int vendorId) {
        return vendorMapper.getVendorShopAddress(vendorId);
    }

    public void deleteVendorShopAddress(int vendorId) {
        Address shopAddress = vendorMapper.getVendorShopAddress(vendorId);
        if(shopAddress == null) {
            return;
        }
        vendorMapper.unLinkVendorShopAddress(vendorId);
        vendorMapper.deleteVendorShopAddress(vendorId);
    }

    public void updateVendorShopAddress(int vendorId, Address shopAddress) {
        vendorMapper.updateVendorShopAddress(shopAddress);
    }
}


