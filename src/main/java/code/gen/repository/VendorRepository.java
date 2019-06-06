
package code.gen.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import code.gen.entities.*;
import java.util.List;

public interface VendorRepository {

    Vendor update(int vendorId, Vendor vendor);

    Vendor get(int vendorId);

    Vendor create(Vendor vendor);

    void delete(int vendorId);



    void addVendorShopAddress(int vendorId, Address shopAddress);

    Address getVendorShopAddress(int vendorId);

    void deleteVendorShopAddress(int vendorId);

    void updateVendorShopAddress(int vendorId, Address shopAddress);



    void linkVendorPaymentOption(int vendorId, int paymentOptionId);

    void unLinkVendorPaymentOption(int vendorId, int paymentOptionId);




    void addVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail);

    AndroidAppDetail getVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    void updateVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail);

    void deleteVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    List<AndroidAppDetail> searchVendorAndroidAppDetails(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    void unLinkVendorAndroidAppDetail(int vendorId, int androidAppDetailId);



    void addVendorGeoLocation(int vendorId, GeoLocation geoLocation);

    GeoLocation getVendorGeoLocation(int vendorId);

    void deleteVendorGeoLocation(int vendorId);

    void updateVendorGeoLocation(int vendorId, GeoLocation geoLocation);




    void addVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming);

    DeliveryTiming getVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    void updateVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming);

    void deleteVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    List<DeliveryTiming> searchVendorDeliveryTimings(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    void unLinkVendorDeliveryTiming(int vendorId, int deliveryTimingId);



    void addVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria);

    DeliveryCriteria getVendorDeliveryCriteria(int vendorId);

    void deleteVendorDeliveryCriteria(int vendorId);

    void updateVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria);



    void linkVendorDeliveryArea(int vendorId, int deliveryAreaId);

    void unLinkVendorDeliveryArea(int vendorId, int deliveryAreaId);


    void addVendorTaxDetails(int vendorId, TaxDetails taxDetails);

    TaxDetails getVendorTaxDetails(int vendorId);

    void deleteVendorTaxDetails(int vendorId);

    void updateVendorTaxDetails(int vendorId, TaxDetails taxDetails);



    void addVendorVendorStatus(int vendorId, VendorStatus vendorStatus);

    VendorStatus getVendorVendorStatus(int vendorId);

    void deleteVendorVendorStatus(int vendorId);

    void updateVendorVendorStatus(int vendorId, VendorStatus vendorStatus);



    void linkVendorDeliveryAgent(int vendorId, int deliveryAgentId);

    void unLinkVendorDeliveryAgent(int vendorId, int deliveryAgentId);


}

