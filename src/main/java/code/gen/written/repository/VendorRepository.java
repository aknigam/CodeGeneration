
package code.gen.written.repository;

import code.gen.entities.*;
import code.gen.written.entities.Address;
import code.gen.written.entities.AndroidAppDetail;
import code.gen.written.entities.DeliveryAgent;
import code.gen.written.entities.DeliveryArea;
import code.gen.written.entities.DeliveryCriteria;
import code.gen.written.entities.DeliveryTiming;
import code.gen.written.entities.GeoLocation;
import code.gen.written.entities.PaymentOption;
import code.gen.written.entities.TaxDetails;
import code.gen.written.entities.Vendor;
import code.gen.written.entities.VendorStatus;

import java.util.List;

public interface VendorRepository {
    // TODO: 26/05/19
    void update(int vendorId, Vendor vendor);

    Vendor get(int vendorId);

    Vendor create(Vendor vendor);

    void delete(int vendorId);



    void addVendorShopAddress(int vendorId, Address shopAddress);

    Address getVendorShopAddress(int vendorId);

    void deleteVendorShopAddress(int vendorId);

    void updateVendorShopAddress(int vendorId, Address shopAddress);





    int addVendorPaymentOption(int vendorId, PaymentOption paymentOption);

    PaymentOption getVendorPaymentOption(int vendorId, int paymentOptionId);

    void updateVendorPaymentOption(int vendorId, PaymentOption paymentOption);

    void deleteVendorPaymentOption(int vendorId, int paymentOptionId);

    List<PaymentOption> searchVendorPaymentOptions(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorPaymentOption(int vendorId, int paymentOptionId);

    void unLinkVendorPaymentOption(int vendorId, int paymentOptionId);






    int addVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail);

    AndroidAppDetail getVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    void updateVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail);

    void deleteVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    List<AndroidAppDetail> searchVendorAndroidAppDetails(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorAndroidAppDetail(int vendorId, int androidAppDetailId);

    void unLinkVendorAndroidAppDetail(int vendorId, int androidAppDetailId);




    int addVendorGeoLocation(int vendorId, GeoLocation geoLocation);

    GeoLocation getVendorGeoLocation(int vendorId);

    void deleteVendorGeoLocation(int vendorId);

    void updateVendorGeoLocation(int vendorId, GeoLocation geoLocation);





    int addVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming);

    DeliveryTiming getVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    void updateVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming);

    void deleteVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    List<DeliveryTiming> searchVendorDeliveryTimings(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorDeliveryTiming(int vendorId, int deliveryTimingId);

    void unLinkVendorDeliveryTiming(int vendorId, int deliveryTimingId);




    int addVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria);

    DeliveryCriteria getVendorDeliveryCriteria(int vendorId);

    void deleteVendorDeliveryCriteria(int vendorId);

    void updateVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria);





    int addVendorDeliveryArea(int vendorId, DeliveryArea deliveryArea);

    DeliveryArea getVendorDeliveryArea(int vendorId, int deliveryAreaId);

    void updateVendorDeliveryArea(int vendorId, DeliveryArea deliveryArea);

    void deleteVendorDeliveryArea(int vendorId, int deliveryAreaId);

    List<DeliveryArea> searchVendorDeliveryAreas(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorDeliveryArea(int vendorId, int deliveryAreaId);

    void unLinkVendorDeliveryArea(int vendorId, int deliveryAreaId);




    int addVendorTaxDetails(int vendorId, TaxDetails taxDetails);

    TaxDetails getVendorTaxDetails(int vendorId);

    void deleteVendorTaxDetails(int vendorId);

    void updateVendorTaxDetails(int vendorId, TaxDetails taxDetails);



    int addVendorVendorStatus(int vendorId, VendorStatus vendorStatus);

    VendorStatus getVendorVendorStatus(int vendorId);

    void deleteVendorVendorStatus(int vendorId);

    void updateVendorVendorStatus(int vendorId, VendorStatus vendorStatus);





    int addVendorDeliveryAgent(int vendorId, DeliveryAgent deliveryAgent);

    DeliveryAgent getVendorDeliveryAgent(int vendorId, int deliveryAgentId);

    void updateVendorDeliveryAgent(int vendorId, DeliveryAgent deliveryAgent);

    void deleteVendorDeliveryAgent(int vendorId, int deliveryAgentId);

    List<DeliveryAgent> searchVendorDeliveryAgents(int vendorId, String nameFilter, int page, int noOfResults);

    void linkVendorDeliveryAgent(int vendorId, int deliveryAgentId);

    void unLinkVendorDeliveryAgent(int vendorId, int deliveryAgentId);




}
