package com.codegen.CodeGeneration.repository;

import com.codegen.CodeGeneration.entity.Vendor;

public interface VendorRepository {
    Vendor update(int vendorId, Vendor vendor);

    Vendor get(int vendorId);

    Vendor create(Vendor vendor);

    void delete(int vendorId);
}
