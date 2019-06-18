
package code.gen.repository.mapper;

import code.gen.entities.*;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VendorMapper {

    @Update(" UPDATE vendor" + 
		" SET code = #{vendor.code}, name = #{vendor.name}, email = #{vendor.email}" + 
		" WHERE (id = #{vendorId})")
    void update(@Param("vendorId") int vendorId, @Param("vendor") Vendor vendor);

    @Select(" SELECT id, code, name, email" + 
		" FROM vendor" + 
		" WHERE (id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "code", property = "code"),
		 @Result(column = "name", property = "name"),
		 @Result(column = "email", property = "email"),
		 @Result(column = "id", property = "owner", javaType= Person.class, one=@One(select="getVendorOwner"))
	})
    Vendor get(@Param("vendorId") int vendorId);

    @Insert(" INSERT INTO vendor" + 
		"  (code, name, email, owner, shop_address)" + 
		" VALUES (#{vendor.code}, #{vendor.name}, #{vendor.email}, #{vendor.owner.id}, #{vendor.shopAddress.id})")
    @Options(useGeneratedKeys=true, keyProperty="vendor.id")
    void create(@Param("vendor") Vendor vendor);

    @Delete(" DELETE FROM vendor" + 
		" WHERE (id = #{vendorId})")
    void delete(@Param("vendorId") int vendorId);








    // one to one methods start for Owner
    @Update(" UPDATE vendor" + 
		" SET owner = null" + 
		" WHERE (id= #{vendorId})")
    void unLinkVendorOwner(int vendorId);

    @Insert(" INSERT INTO person" + 
		"  (first_name, last_name, middle_name, mobile_number, email)" + 
		" VALUES (#{owner.firstName}, #{owner.lastName}, #{owner.middleName}, #{owner.mobileNumber}, #{owner.email})")
    @Options(useGeneratedKeys=true, keyProperty="owner.id")
    void addVendorOwner(@Param("owner") Person owner);

    @Update(" UPDATE vendor" + 
		" SET owner = #{ownerId}" + 
		" WHERE (id = #{vendorId} )")
    void linkVendorOwner(@Param("vendorId") int vendorId, @Param("ownerId") int ownerId);

    @Select(" SELECT p.id, p.first_name, p.last_name, p.middle_name, p.mobile_number, p.email" + 
		" FROM person p" + 
		" JOIN vendor v on v.owner = p.id" + 
		" WHERE (v.id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "first_name", property = "firstName"),
		 @Result(column = "last_name", property = "lastName"),
		 @Result(column = "middle_name", property = "middleName"),
		 @Result(column = "mobile_number", property = "mobileNumber"),
		 @Result(column = "email", property = "email")
	})
    Person getVendorOwner(int vendorId);

    @Delete(" DELETE FROM person" + 
		" WHERE (id = (select id from vendor where id = #{vendorId}))")
    void deleteVendorOwner(int vendorId);

    @Update(" UPDATE p.person" + 
		" SET first_name = #{p.firstName}, last_name = #{p.lastName}, middle_name = #{p.middleName}, mobile_number = #{p.mobileNumber}, email = #{p.email}")
    void updateVendorOwner(Person owner);

    // one to one methods ends for Owner


    // one to one methods start for ShopAddress
    @Update(" UPDATE vendor" + 
		" SET shop_address = null" + 
		" WHERE (id= #{vendorId})")
    void unLinkVendorShopAddress(int vendorId);

    @Insert(" INSERT INTO address" + 
		"  (line1, line2, area, city, pin_code, state, country)" + 
		" VALUES (#{shopAddress.line1}, #{shopAddress.line2}, #{shopAddress.area}, #{shopAddress.city}, #{shopAddress.pinCode}, #{shopAddress.state}, #{shopAddress.country})")
    @Options(useGeneratedKeys=true, keyProperty="shopAddress.id")
    void addVendorShopAddress(@Param("shopAddress") Address shopAddress);

    @Update(" UPDATE vendor" + 
		" SET shop_address = #{shopAddressId}" + 
		" WHERE (id = #{vendorId} )")
    void linkVendorShopAddress(@Param("vendorId") int vendorId, @Param("shopAddressId") int shopAddressId);

    @Select(" SELECT a.id, a.line1, a.line2, a.area, a.city, a.pin_code, a.state, a.country" + 
		" FROM address a" + 
		" JOIN vendor v on v.shop_address = a.id" + 
		" WHERE (v.id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "line1", property = "line1"),
		 @Result(column = "line2", property = "line2"),
		 @Result(column = "area", property = "area"),
		 @Result(column = "city", property = "city"),
		 @Result(column = "pin_code", property = "pinCode"),
		 @Result(column = "state", property = "State"),
		 @Result(column = "country", property = "Country")
	})
    Address getVendorShopAddress(int vendorId);

    @Delete(" DELETE FROM address" + 
		" WHERE (id = (select id from vendor where id = #{vendorId}))")
    void deleteVendorShopAddress(int vendorId);

    @Update(" UPDATE a.address" + 
		" SET line1 = #{a.line1}, line2 = #{a.line2}, area = #{a.area}, city = #{a.city}, pin_code = #{a.pinCode}, state = #{a.State}, country = #{a.Country}")
    void updateVendorShopAddress(Address shopAddress);

    // one to one methods ends for ShopAddress




}
