package com.codegen.CodeGeneration.service;

import com.codegen.CodeGeneration.entity.Vendor;

public interface VendorService {
    Vendor update(Vendor vendor);

    Vendor get(int vendorId);

    Vendor create(Vendor vendor);

    void delete(int vendorId);

}
