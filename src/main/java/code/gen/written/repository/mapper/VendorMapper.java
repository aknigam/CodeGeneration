
package code.gen.written.repository.mapper;

import code.gen.written.entities.Address;
import code.gen.written.entities.AndroidAppDetail;
import code.gen.written.entities.DeliveryAgent;
import code.gen.written.entities.Vendor;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

//@Mapper
public interface VendorMapper {
    // TODO: 26/05/19
    @Update("Update vendor set name = #{vendor.name}, code = #{code} ,email = #{vendor.email}  where id = " +
            "#{vendorId}")
    void update(@Param("vendorId") int vendorId, @Param("vendor") Vendor vendor);

    @Select("Select id , code, name, email, shop_address from vendor where id = #{vendorId}")
    @Results({
            @Result(column = "shop_address", property = "shopAddress" , javaType = Address.class ,
                    one = @One(select = "getShopAddress", fetchType= FetchType.EAGER)),
    })
    Vendor get(@Param("vendorId") int vendorId);

    @Select("select id, line1, line2 from address where id = #{id}")
    Address getShopAddress(int id);

    @Insert({"insert into vendor (code, name, email) values (#{vendor.name}, #{vendor.code}, #{vendor.email}) "})
    @Options(useGeneratedKeys=true, keyProperty="id")
    void create(@Param("vendor") Vendor vendor);

    @Delete("Delete from vendor where id = #{vendorId}")
    void delete(@Param("vendorId") int vendorId);

//    one to one starts

    @Insert("insert into address (line1, line2, area) values (#{shopAddress.line1}, #{shopAddress.line2}, " +
            "#{shopAddress.area}")
    @Options(useGeneratedKeys=true, keyProperty="shopAddress.id")
    void addVendorShopAddress(@Param("shopAddress") Address shopAddress);

    @Update("update vendor set shop_address = #{shopAdress} where id = #{vendorId}")
    void linkVendorShopAddress(@Param("vendorId") int vendorId, @Param("shopAdress") Integer addressId);

    @Update("update vendor set shop_address = null where id = #{vendorId}")
    void unLinkVendorShopAddress(@Param("vendorId") int vendorId, @Param("shopAdress") Integer addressId);

    @Select("select a.id, a.line1, a.line2 from address a " +
            " join vendor v on v.shop_address = a.id" +
            " where v.id =  #{vendorId}")
    @Results({
            @Result(column = "id", property= "id"),
            @Result(column = "line1", property = "line1"),
            @Result(column = "line2", property = "line2")
    })
    Address getVendorShopAddress(@Param("vendorId") int vendorId);

    @Delete("DELETE from address where id =  #{addressId}")
    void deleteVendorShopAddress(@Param("addressId") int vendorId);

    @Update("update address SET line1 = #{shopAddress.line1}, line2 = #{shopAddress.line2} " +
            "where id = (select shop_address from vendor where id = #{vendorId})")
    void updateVendorShopAddress(@Param("vendorId") int vendorId, @Param("shopAddress") Address shopAddress);

//    one to one ends


//  one to many
    @Insert("insert into android_app_detail (android_token, vendor_id) " +
            "values (#{androidAppDetail.androidToken}, #{vendorId})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int addVendorAndroidAppDetail(@Param("vendorId") int vendorId, @Param("androidAppDetail") AndroidAppDetail androidAppDetail);

    AndroidAppDetail getVendorAndroidAppDetail(@Param("vendorId") int vendorId, int androidAppDetailId);

    void updateVendorAndroidAppDetail(@Param("vendorId") int vendorId, AndroidAppDetail androidAppDetail);

    void deleteVendorAndroidAppDetail(@Param("vendorId") int vendorId, int androidAppDetailId);

    List<AndroidAppDetail> searchVendorAndroidAppDetails(@Param("vendorId") int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorAndroidAppDetail(@Param("vendorId") int vendorId, int androidAppDetailId);

    void unLinkVendorAndroidAppDetail(@Param("vendorId") int vendorId, int androidAppDetailId);
    //  one to many

//    many to many
    int addVendorDeliveryAgent(@Param("vendorId") int vendorId, DeliveryAgent deliveryAgent);

    DeliveryAgent getVendorDeliveryAgent(@Param("vendorId") int vendorId, int deliveryAgentId);

    void updateVendorDeliveryAgent(@Param("vendorId") int vendorId, DeliveryAgent deliveryAgent);

    void deleteVendorDeliveryAgent(@Param("vendorId") int vendorId, int deliveryAgentId);

    List<DeliveryAgent> searchVendorDeliveryAgents(@Param("vendorId") int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorDeliveryAgent(@Param("vendorId") int vendorId, int deliveryAgentId);

    void unLinkVendorDeliveryAgent(@Param("vendorId") int vendorId, int deliveryAgentId);


//    many to many
}
