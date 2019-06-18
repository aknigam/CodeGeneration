
package code.gen.service;

import code.gen.entities.*;
import code.gen.service.VendorService;
import code.gen.repository.VendorRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;


    @Override
    public Vendor update(int vendorId, Vendor vendor) {
        return vendorRepository.update(vendorId, vendor);
    }

    @Override
    public Vendor get(int vendorId) {
        return vendorRepository.get(vendorId);
    }

    @Override
    public Vendor create(Vendor vendor) {
        return vendorRepository.create(vendor);
    }

    @Override
    public void delete(int vendorId) {
        vendorRepository.delete(vendorId);
    }











//    ONE TO ONE starts
    @Override
    public void addVendorShopAddress(int vendorId, Address shopAddress) {
        vendorRepository.addVendorShopAddress(vendorId, shopAddress);
    }

    @Override
    public Address getVendorShopAddress(int vendorId) {
        return vendorRepository.getVendorShopAddress(vendorId);
    }

    @Override
    public void deleteVendorShopAddress(int vendorId) {
        vendorRepository.deleteVendorShopAddress(vendorId);
    }

    @Override
    public void updateVendorShopAddress(int vendorId, Address shopAddress) {
        vendorRepository.updateVendorShopAddress(vendorId, shopAddress);
    }



}

