
package code.gen.written.service;

import code.gen.entities.*;
import code.gen.written.repository.VendorRepository;
import java.util.List;

import code.gen.written.entities.Address;
import code.gen.written.entities.AndroidAppDetail;
import code.gen.written.entities.DeliveryCriteria;
import code.gen.written.entities.DeliveryTiming;
import code.gen.written.entities.GeoLocation;
import code.gen.written.entities.PaymentOption;
import code.gen.written.entities.TaxDetails;
import code.gen.written.entities.Vendor;
import code.gen.written.entities.VendorStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;


    // TODO: 26/05/19
    @Override
    public void update(int vendorId, Vendor vendor) {
        vendorRepository.update(vendorId, vendor);
    }

    @Override
    public Vendor get(int vendorId) {
        return vendorRepository.get(vendorId);
    }

    @Override
    public Vendor create(Vendor vendor) {
        return vendorRepository.create(vendor);
    }

    @Override
    public void delete(int vendorId) {
        vendorRepository.delete(vendorId);
    }












//    ONE TO ONE starts
// TODO: 26/05/19
    @Override
    public void addVendorShopAddress(int vendorId, Address shopAddress) {
        vendorRepository.addVendorShopAddress(vendorId, shopAddress);
    }

    @Override
    public Address getVendorShopAddress(int vendorId) {
        return vendorRepository.getVendorShopAddress(vendorId);
    }

    @Override
    public void deleteVendorShopAddress(int vendorId) {
        vendorRepository.deleteVendorShopAddress(vendorId);
    }

    @Override
    public void updateVendorShopAddress(int vendorId, Address shopAddress) {
        vendorRepository.updateVendorShopAddress(vendorId, shopAddress);
    }





//    ONE TO MANY START
    @Override
    public int addVendorPaymentOption(int vendorId, PaymentOption paymentOption) {
        return vendorRepository.addVendorPaymentOption(vendorId, paymentOption);
    }

    @Override
    public PaymentOption getVendorPaymentOption(int vendorId, int paymentOptionId) {
        return  vendorRepository.getVendorPaymentOption(vendorId, paymentOptionId);
    }

    @Override
    public void updateVendorPaymentOption(int vendorId, PaymentOption paymentOption) {
        vendorRepository.updateVendorPaymentOption(vendorId, paymentOption);
    }

    @Override
    public void deleteVendorPaymentOption(int vendorId, int paymentOptionId) {
        vendorRepository.deleteVendorPaymentOption(vendorId, paymentOptionId);
    }

    @Override
    public List<PaymentOption> searchVendorPaymentOptions(int vendorId, String nameFilter, int page, int noOfResults) {
        return vendorRepository.searchVendorPaymentOptions(vendorId, nameFilter, page, noOfResults);
    }

    @Override
    public void linkVendorPaymentOption(int vendorId, int paymentOptionId) {
        vendorRepository.linkVendorPaymentOption(vendorId, paymentOptionId);
    }

    @Override
    public void unLinkVendorPaymentOption(int vendorId, int paymentOptionId) {
        vendorRepository.unLinkVendorPaymentOption(vendorId, paymentOptionId);
    }


//    ONE TO MANY END




//    ONE TO MANY START
    @Override
    public int addVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail) {
        return vendorRepository.addVendorAndroidAppDetail(vendorId, androidAppDetail);
    }

    @Override
    public AndroidAppDetail getVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        return  vendorRepository.getVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    @Override
    public void updateVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail) {
        vendorRepository.updateVendorAndroidAppDetail(vendorId, androidAppDetail);
    }

    @Override
    public void deleteVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        vendorRepository.deleteVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    @Override
    public List<AndroidAppDetail> searchVendorAndroidAppDetails(int vendorId, String nameFilter, int page, int noOfResults) {
        return vendorRepository.searchVendorAndroidAppDetails(vendorId, nameFilter, page, noOfResults);
    }

    @Override
    public void linkVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        vendorRepository.linkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    @Override
    public void unLinkVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        vendorRepository.unLinkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }


//    ONE TO MANY END




//    ONE TO ONE starts
    @Override
    public int addVendorGeoLocation(int vendorId, GeoLocation geoLocation) {
        int geoLocationId =   vendorRepository.addVendorGeoLocation(vendorId, geoLocation);
    return geoLocationId;
    }

    @Override
    public GeoLocation getVendorGeoLocation(int vendorId) {
        return vendorRepository.getVendorGeoLocation(vendorId);
    }

    @Override
    public void deleteVendorGeoLocation(int vendorId) {
        vendorRepository.deleteVendorGeoLocation(vendorId);
    }

    @Override
    public void updateVendorGeoLocation(int vendorId, GeoLocation geoLocation) {
        vendorRepository.updateVendorGeoLocation(vendorId, geoLocation);
    }





//    ONE TO MANY START
    @Override
    public int addVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {
        return vendorRepository.addVendorDeliveryTiming(vendorId, deliveryTiming);
    }

    @Override
    public DeliveryTiming getVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        return  vendorRepository.getVendorDeliveryTiming(vendorId, deliveryTimingId);
    }

    @Override
    public void updateVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {
        vendorRepository.updateVendorDeliveryTiming(vendorId, deliveryTiming);
    }

    @Override
    public void deleteVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        vendorRepository.deleteVendorDeliveryTiming(vendorId, deliveryTimingId);
    }

    @Override
    public List<DeliveryTiming> searchVendorDeliveryTimings(int vendorId, String nameFilter, int page, int noOfResults) {
        return vendorRepository.searchVendorDeliveryTimings(vendorId, nameFilter, page, noOfResults);
    }

    @Override
    public void linkVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        vendorRepository.linkVendorDeliveryTiming(vendorId, deliveryTimingId);
    }

    @Override
    public void unLinkVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        vendorRepository.unLinkVendorDeliveryTiming(vendorId, deliveryTimingId);
    }


//    ONE TO MANY END




//    ONE TO ONE starts
    @Override
    public int addVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {
        int deliveryCriteriaId =   vendorRepository.addVendorDeliveryCriteria(vendorId, deliveryCriteria);
    return deliveryCriteriaId;
    }

    @Override
    public DeliveryCriteria getVendorDeliveryCriteria(int vendorId) {
        return vendorRepository.getVendorDeliveryCriteria(vendorId);
    }

    @Override
    public void deleteVendorDeliveryCriteria(int vendorId) {
        vendorRepository.deleteVendorDeliveryCriteria(vendorId);
    }

    @Override
    public void updateVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {
        vendorRepository.updateVendorDeliveryCriteria(vendorId, deliveryCriteria);
    }




    @Override
    public void linkVendorDeliveryArea(int vendorId, int deliveryAreaId) {
        vendorRepository.linkVendorDeliveryArea(vendorId, deliveryAreaId);
    }

    @Override
    public void unLinkVendorDeliveryArea(int vendorId, int deliveryAreaId) {
        vendorRepository.unLinkVendorDeliveryArea(vendorId, deliveryAreaId);
    }




//    ONE TO ONE starts
    @Override
    public int addVendorTaxDetails(int vendorId, TaxDetails taxDetails) {
        int taxDetailsId =   vendorRepository.addVendorTaxDetails(vendorId, taxDetails);
    return taxDetailsId;
    }

    @Override
    public TaxDetails getVendorTaxDetails(int vendorId) {
        return vendorRepository.getVendorTaxDetails(vendorId);
    }

    @Override
    public void deleteVendorTaxDetails(int vendorId) {
        vendorRepository.deleteVendorTaxDetails(vendorId);
    }

    @Override
    public void updateVendorTaxDetails(int vendorId, TaxDetails taxDetails) {
        vendorRepository.updateVendorTaxDetails(vendorId, taxDetails);
    }





//    ONE TO ONE starts
    @Override
    public int addVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {
        int vendorStatusId =   vendorRepository.addVendorVendorStatus(vendorId, vendorStatus);
    return vendorStatusId;
    }

    @Override
    public VendorStatus getVendorVendorStatus(int vendorId) {
        return vendorRepository.getVendorVendorStatus(vendorId);
    }

    @Override
    public void deleteVendorVendorStatus(int vendorId) {
        vendorRepository.deleteVendorVendorStatus(vendorId);
    }

    @Override
    public void updateVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {
        vendorRepository.updateVendorVendorStatus(vendorId, vendorStatus);
    }




    @Override
    public void linkVendorDeliveryAgent(int vendorId, int deliveryAgentId) {
        vendorRepository.linkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }

    @Override
    public void unLinkVendorDeliveryAgent(int vendorId, int deliveryAgentId) {
        vendorRepository.unLinkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }


}

