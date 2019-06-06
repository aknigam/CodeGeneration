
package code.gen.repository.mapper;

import code.gen.entities.*;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VendorMapper {

    @Update(" UPDATE vendor" + 
		" SET code = #{vendor.code}, name = #{vendor.name}, email = #{vendor.email}, mobile_number = #{vendor.mobileNumber}" + 
		" WHERE (id = #{vendorId})")
    Vendor update(@Param("vendorId") int vendorId, @Param("vendor") Vendor vendor);

    @Select(" SELECT id, code, name, email, mobile_number" + 
		" FROM vendor" + 
		" WHERE (id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "code", property = "code"),
		 @Result(column = "name", property = "name"),
		 @Result(column = "email", property = "email"),
		 @Result(column = "id", property = "owner", javaType= Person.class, one=@One(select="getVendorOwner")),
		 @Result(column = "mobile_number", property = "mobileNumber")
	})
    Vendor get(@Param("vendorId") int vendorId);

    @Insert(" INSERT INTO vendor" + 
		"  (code, name, email, mobile_number)" + 
		" VALUES (#{vendor.code}, #{vendor.name}, #{vendor.email}, #{vendor.mobileNumber})")
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

    @Update(" DELETE FROM person" + 
		" WHERE (id = (Select id from vendor where id  = #{vendorId}))")
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

    @Update(" DELETE FROM address" + 
		" WHERE (id = (Select id from vendor where id  = #{vendorId}))")
    void updateVendorShopAddress(Address shopAddress);

    // one to one methods ends for ShopAddress



    // many to many methods starts for PaymentOption

    @Insert(" INSERT INTO vendor_payment_option" + 
		"  (name, description)" + 
		" VALUES (#{paymentOption.name}, #{paymentOption.description})")
    @Options(useGeneratedKeys=true, keyProperty="paymentOption.id")
    void addVendorPaymentOption(@Param("paymentOption") PaymentOption paymentOption);

    @Select(" SELECT id, name, description" + 
		" FROM vendor_payment_option" + 
		" WHERE (id = #{PaymentOptionId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "name", property = "name"),
		 @Result(column = "description", property = "description")
	})
    PaymentOption getVendorPaymentOption(int paymentOptionId);

    @Select(" SELECT id, name, description" + 
		" FROM vendor_payment_option" + 
		" WHERE (id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "name", property = "name"),
		 @Result(column = "description", property = "description")
	})
    List<PaymentOption> getVendorPaymentOptions(int vendorId);

    @Update(" UPDATE vendor_payment_option" + 
		" SET name = #{paymentOption.name}, description = #{paymentOption.description}" + 
		" WHERE (id = #{PaymentOptionId})")
    void updateVendorPaymentOption(PaymentOption paymentOption);

    @Delete("delete from vendor_payment_option where vendor_id = #{vendorId}  and payment_option_id = #{ PaymentOptionId}")
    void unLinkVendorPaymentOption(@Param("vendorId") int vendorId, @Param("paymentOptionId")  int paymentOptionId);

    @Insert("Insert into vendor_payment_option ( vendor_id, payment_option_id) values ( #{vendorId} ,  #{ PaymentOptionId}")
    void linkVendorPaymentOption(@Param("vendorId") int vendorId, @Param("paymentOptionId")  int paymentOptionId);

    @Delete(" DELETE FROM vendor_payment_option" + 
		" WHERE (id = #{PaymentOptionId})")
    void deleteVendorPaymentOption(@Param("paymentOptionId") int paymentOptionId);

    // many to many methods ends for PaymentOption


    // one to many methods start for AndroidAppDetail

    @Update(" UPDATE android_app_detail" + 
		" SET vendor_id= null")
    void unLinkVendorAndroidAppDetail(int vendorId,  int androidAppDetailId);

    @Update(" UPDATE android_app_detail" + 
		" SET vendor_id= #{vendorId}")
    void linkVendorAndroidAppDetail(int vendorId,  int androidAppDetailId);

    @Insert(" INSERT INTO android_app_detail" + 
		"  (android_token)" + 
		" VALUES (#{androidAppDetail.androidToken})")
    @Options(useGeneratedKeys=true, keyProperty="androidAppDetail.id")
    void addVendorAndroidAppDetail(@Param("vendorId") int vendorId, @Param("androidAppDetail") AndroidAppDetail androidAppDetail);

    @Select(" SELECT id, android_token" + 
		" FROM android_app_detail" + 
		" WHERE (id = #{AndroidAppDetailId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "android_token", property = "androidToken")
	})
    AndroidAppDetail getVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    @Select(" SELECT id, android_token" + 
		" FROM android_app_detail" + 
		" WHERE (vendor_id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "android_token", property = "androidToken")
	})
    List<AndroidAppDetail> getVendorAndroidAppDetails(int vendorId);

    @Delete(" DELETE FROM android_app_detail" + 
		" WHERE (id = #{AndroidAppDetailId})")
    void deleteVendorAndroidAppDetail(int androidAppDetailId);

    @Update(" UPDATE android_app_detail" + 
		" SET android_token = #{androidAppDetail.androidToken}" + 
		" WHERE (id = #{AndroidAppDetailId})")
    void updateVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail);


    // one to many methods ends for AndroidAppDetail


    // one to one methods start for GeoLocation
    @Update(" UPDATE vendor" + 
		" SET geo_location = null" + 
		" WHERE (id= #{vendorId})")
    void unLinkVendorGeoLocation(int vendorId);

    @Insert(" INSERT INTO geo_location" + 
		"  (geo_location)" + 
		" VALUES (#{geoLocation.geoLocation})")
    @Options(useGeneratedKeys=true, keyProperty="geoLocation.id")
    void addVendorGeoLocation(@Param("geoLocation") GeoLocation geoLocation);

    @Update(" UPDATE vendor" + 
		" SET geo_location = #{geoLocationId}" + 
		" WHERE (id = #{vendorId} )")
    void linkVendorGeoLocation(@Param("vendorId") int vendorId, @Param("geoLocationId") int geoLocationId);

    @Select(" SELECT gl.id, gl.geo_location" + 
		" FROM geo_location gl" + 
		" JOIN vendor v on v.geo_location = gl.id" + 
		" WHERE (v.id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "geo_location", property = "GeoLocation")
	})
    GeoLocation getVendorGeoLocation(int vendorId);

    @Delete(" DELETE FROM geo_location" + 
		" WHERE (id = (select id from vendor where id = #{vendorId}))")
    void deleteVendorGeoLocation(int vendorId);

    @Update(" DELETE FROM geo_location" + 
		" WHERE (id = (Select id from vendor where id  = #{vendorId}))")
    void updateVendorGeoLocation(GeoLocation geoLocation);

    // one to one methods ends for GeoLocation



    // one to many methods start for DeliveryTiming

    @Update(" UPDATE delivery_timing" + 
		" SET vendor_id= null")
    void unLinkVendorDeliveryTiming(int vendorId,  int deliveryTimingId);

    @Update(" UPDATE delivery_timing" + 
		" SET vendor_id= #{vendorId}")
    void linkVendorDeliveryTiming(int vendorId,  int deliveryTimingId);

    @Insert(" INSERT INTO delivery_timing" + 
		"  (start_time, end_time)" + 
		" VALUES (#{deliveryTiming.startTime}, #{deliveryTiming.endTime})")
    @Options(useGeneratedKeys=true, keyProperty="deliveryTiming.id")
    void addVendorDeliveryTiming(@Param("vendorId") int vendorId, @Param("deliveryTiming") DeliveryTiming deliveryTiming);

    @Select(" SELECT id, start_time, end_time" + 
		" FROM delivery_timing" + 
		" WHERE (id = #{deliveryTimingId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "start_time", property = "startTime"),
		 @Result(column = "end_time", property = "endTime")
	})
    DeliveryTiming getVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    @Select(" SELECT id, start_time, end_time" + 
		" FROM delivery_timing" + 
		" WHERE (vendor_id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "start_time", property = "startTime"),
		 @Result(column = "end_time", property = "endTime")
	})
    List<DeliveryTiming> getVendorDeliveryTimings(int vendorId);

    @Delete(" DELETE FROM delivery_timing" + 
		" WHERE (id = #{deliveryTimingId})")
    void deleteVendorDeliveryTiming(int deliveryTimingId);

    @Update(" UPDATE delivery_timing" + 
		" SET start_time = #{deliveryTiming.startTime}, end_time = #{deliveryTiming.endTime}" + 
		" WHERE (id = #{deliveryTimingId})")
    void updateVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming);


    // one to many methods ends for DeliveryTiming


    // one to one methods start for DeliveryCriteria
    @Update(" UPDATE vendor" + 
		" SET delivery_criteria = null" + 
		" WHERE (id= #{vendorId})")
    void unLinkVendorDeliveryCriteria(int vendorId);

    @Insert(" INSERT INTO delivery_criteria" + 
		"  (name, description)" + 
		" VALUES (#{deliveryCriteria.name}, #{deliveryCriteria.description})")
    @Options(useGeneratedKeys=true, keyProperty="deliveryCriteria.id")
    void addVendorDeliveryCriteria(@Param("deliveryCriteria") DeliveryCriteria deliveryCriteria);

    @Update(" UPDATE vendor" + 
		" SET delivery_criteria = #{deliveryCriteriaId}" + 
		" WHERE (id = #{vendorId} )")
    void linkVendorDeliveryCriteria(@Param("vendorId") int vendorId, @Param("deliveryCriteriaId") int deliveryCriteriaId);

    @Select(" SELECT dc.id, dc.name, dc.description" + 
		" FROM delivery_criteria dc" + 
		" JOIN vendor v on v.delivery_criteria = dc.id" + 
		" WHERE (v.id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "name", property = "name"),
		 @Result(column = "description", property = "description")
	})
    DeliveryCriteria getVendorDeliveryCriteria(int vendorId);

    @Delete(" DELETE FROM delivery_criteria" + 
		" WHERE (id = (select id from vendor where id = #{vendorId}))")
    void deleteVendorDeliveryCriteria(int vendorId);

    @Update(" DELETE FROM delivery_criteria" + 
		" WHERE (id = (Select id from vendor where id  = #{vendorId}))")
    void updateVendorDeliveryCriteria(DeliveryCriteria deliveryCriteria);

    // one to one methods ends for DeliveryCriteria



    // one to many methods start for DeliveryArea

    @Update(" UPDATE delivery_area" + 
		" SET vendor_id= null")
    void unLinkVendorDeliveryArea(int vendorId,  int deliveryAreaId);

    @Update(" UPDATE delivery_area" + 
		" SET vendor_id= #{vendorId}")
    void linkVendorDeliveryArea(int vendorId,  int deliveryAreaId);

    @Insert(" INSERT INTO delivery_area" + 
		"  (pin_code)" + 
		" VALUES (#{deliveryArea.pinCode})")
    @Options(useGeneratedKeys=true, keyProperty="deliveryArea.id")
    void addVendorDeliveryArea(@Param("vendorId") int vendorId, @Param("deliveryArea") DeliveryArea deliveryArea);

    @Select(" SELECT id, pin_code" + 
		" FROM delivery_area" + 
		" WHERE (id = #{DeliveryAreaId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "pin_code", property = "pinCode")
	})
    DeliveryArea getVendorDeliveryArea(int vendorId, int deliveryAreaId);

    @Select(" SELECT id, pin_code" + 
		" FROM delivery_area" + 
		" WHERE (vendor_id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "pin_code", property = "pinCode")
	})
    List<DeliveryArea> getVendorDeliveryAreas(int vendorId);

    @Delete(" DELETE FROM delivery_area" + 
		" WHERE (id = #{DeliveryAreaId})")
    void deleteVendorDeliveryArea(int deliveryAreaId);

    @Update(" UPDATE delivery_area" + 
		" SET pin_code = #{deliveryArea.pinCode}" + 
		" WHERE (id = #{DeliveryAreaId})")
    void updateVendorDeliveryArea(int vendorId, DeliveryArea deliveryArea);


    // one to many methods ends for DeliveryArea


    // one to one methods start for TaxDetails
    @Update(" UPDATE vendor" + 
		" SET tax_details = null" + 
		" WHERE (id= #{vendorId})")
    void unLinkVendorTaxDetails(int vendorId);

    @Insert(" INSERT INTO tax_details" + 
		"  (pan_number, gst_number)" + 
		" VALUES (#{taxDetails.panNumber}, #{taxDetails.gstNumber})")
    @Options(useGeneratedKeys=true, keyProperty="taxDetails.id")
    void addVendorTaxDetails(@Param("taxDetails") TaxDetails taxDetails);

    @Update(" UPDATE vendor" + 
		" SET tax_details = #{taxDetailsId}" + 
		" WHERE (id = #{vendorId} )")
    void linkVendorTaxDetails(@Param("vendorId") int vendorId, @Param("taxDetailsId") int taxDetailsId);

    @Select(" SELECT td.id, td.pan_number, td.gst_number" + 
		" FROM tax_details td" + 
		" JOIN vendor v on v.tax_details = td.id" + 
		" WHERE (v.id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "pan_number", property = "panNumber"),
		 @Result(column = "gst_number", property = "gstNumber")
	})
    TaxDetails getVendorTaxDetails(int vendorId);

    @Delete(" DELETE FROM tax_details" + 
		" WHERE (id = (select id from vendor where id = #{vendorId}))")
    void deleteVendorTaxDetails(int vendorId);

    @Update(" DELETE FROM tax_details" + 
		" WHERE (id = (Select id from vendor where id  = #{vendorId}))")
    void updateVendorTaxDetails(TaxDetails taxDetails);

    // one to one methods ends for TaxDetails


    // one to one methods start for VendorStatus
    @Update(" UPDATE vendor" + 
		" SET vendor_status = null" + 
		" WHERE (id= #{vendorId})")
    void unLinkVendorVendorStatus(int vendorId);

    @Insert(" INSERT INTO vendor_status" + 
		"  (status_name)" + 
		" VALUES (#{vendorStatus.statusName})")
    @Options(useGeneratedKeys=true, keyProperty="vendorStatus.id")
    void addVendorVendorStatus(@Param("vendorStatus") VendorStatus vendorStatus);

    @Update(" UPDATE vendor" + 
		" SET vendor_status = #{vendorStatusId}" + 
		" WHERE (id = #{vendorId} )")
    void linkVendorVendorStatus(@Param("vendorId") int vendorId, @Param("vendorStatusId") int vendorStatusId);

    @Select(" SELECT vs.id, vs.status_name" + 
		" FROM vendor_status vs" + 
		" JOIN vendor v on v.vendor_status = vs.id" + 
		" WHERE (v.id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "status_name", property = "statusName")
	})
    VendorStatus getVendorVendorStatus(int vendorId);

    @Delete(" DELETE FROM vendor_status" + 
		" WHERE (id = (select id from vendor where id = #{vendorId}))")
    void deleteVendorVendorStatus(int vendorId);

    @Update(" DELETE FROM vendor_status" + 
		" WHERE (id = (Select id from vendor where id  = #{vendorId}))")
    void updateVendorVendorStatus(VendorStatus vendorStatus);

    // one to one methods ends for VendorStatus



    // many to many methods starts for DeliveryAgent

    @Insert(" INSERT INTO vendor_delivery_agent" + 
		"  (first_name, last_name)" + 
		" VALUES (#{deliveryAgent.firstName}, #{deliveryAgent.lastName})")
    @Options(useGeneratedKeys=true, keyProperty="deliveryAgent.id")
    void addVendorDeliveryAgent(@Param("deliveryAgent") DeliveryAgent deliveryAgent);

    @Select(" SELECT id, first_name, last_name" + 
		" FROM vendor_delivery_agent" + 
		" WHERE (id = #{deliveryAgentId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "first_name", property = "firstName"),
		 @Result(column = "last_name", property = "lastName")
	})
    DeliveryAgent getVendorDeliveryAgent(int deliveryAgentId);

    @Select(" SELECT id, first_name, last_name" + 
		" FROM vendor_delivery_agent" + 
		" WHERE (id = #{vendorId})")
    @Results({
		 @Result(column = "id", property = "id"),
		 @Result(column = "first_name", property = "firstName"),
		 @Result(column = "last_name", property = "lastName")
	})
    List<DeliveryAgent> getVendorDeliveryAgents(int vendorId);

    @Update(" UPDATE vendor_delivery_agent" + 
		" SET first_name = #{deliveryAgent.firstName}, last_name = #{deliveryAgent.lastName}" + 
		" WHERE (id = #{deliveryAgentId})")
    void updateVendorDeliveryAgent(DeliveryAgent deliveryAgent);

    @Delete("delete from vendor_delivery_agent where vendor_id = #{vendorId}  and delivery_agent_id = #{ deliveryAgentId}")
    void unLinkVendorDeliveryAgent(@Param("vendorId") int vendorId, @Param("deliveryAgentId")  int deliveryAgentId);

    @Insert("Insert into vendor_delivery_agent ( vendor_id, delivery_agent_id) values ( #{vendorId} ,  #{ deliveryAgentId}")
    void linkVendorDeliveryAgent(@Param("vendorId") int vendorId, @Param("deliveryAgentId")  int deliveryAgentId);

    @Delete(" DELETE FROM vendor_delivery_agent" + 
		" WHERE (id = #{deliveryAgentId})")
    void deleteVendorDeliveryAgent(@Param("deliveryAgentId") int deliveryAgentId);

    // many to many methods ends for DeliveryAgent



}
