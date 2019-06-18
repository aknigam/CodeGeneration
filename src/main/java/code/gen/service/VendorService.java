
package code.gen.service;

import code.gen.entities.*;
import java.util.List;


public interface VendorService {

    Vendor update(int vendorId, Vendor vendor);

    Vendor get(int vendorId);

    Vendor create(Vendor vendor);

    void delete(int vendorId);













    void addVendorShopAddress(int vendorId, Address shopAddress);

    Address getVendorShopAddress(int vendorId);

    void deleteVendorShopAddress(int vendorId);

    void updateVendorShopAddress(int vendorId, Address shopAddress);




}


