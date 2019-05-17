package com.codegen.CodeGeneration.repository;

import com.codegen.CodeGeneration.entity.Vendor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VendorMapper {

    @Update("Update vendor set name = #{}")
    Vendor update(@Param("vendorId") int vendorId, @Param("vendor") Vendor vendor);

    @Select("Select id from vendor where id = #{vendorId}")
    Vendor get(@Param("vendorId") int vendorId);

    @Insert("Insert into vendor () values () ")
    void create(@Param("vendor") Vendor vendor);

    @Delete("Delete from vendor where id = #{vendorId}")
    void delete(@Param("vendorId") int vendorId);
}
