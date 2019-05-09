package com.codegen.CodeGeneration.entity;

import javax.validation.constraints.NotNull;

public class Vendor {

    @NotNull
    private int id;

    public Vendor(){}

    public Vendor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
