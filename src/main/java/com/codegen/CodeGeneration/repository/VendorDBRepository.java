package com.codegen.CodeGeneration.repository;

import com.codegen.CodeGeneration.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDBRepository implements VendorRepository {

    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public Vendor update(int vendorId, Vendor vendor) {
        return vendorMapper.update(vendorId, vendor);
    }

    @Override
    public Vendor get(int vendorId) {
        return vendorMapper.get(vendorId);
    }

    @Override
    public Vendor create(Vendor vendor) {
        vendorMapper.create(vendor);
        return vendor;
    }

    @Override
    public void delete(int vendorId) {
        vendorMapper.delete(vendorId);
    }
}
