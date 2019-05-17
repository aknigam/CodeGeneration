package com.codegen.CodeGeneration.service;

import com.codegen.CodeGeneration.entity.Vendor;
import com.codegen.CodeGeneration.repository.VendorRepository;
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
}
