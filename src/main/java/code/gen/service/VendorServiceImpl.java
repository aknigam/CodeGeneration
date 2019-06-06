
package code.gen.service;

import code.gen.entities.*;
import code.gen.service.VendorService;
import code.gen.repository.VendorRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;


    @Override
    public Vendor update(int vendorId, Vendor vendor) {
        return vendorRepository.update(vendorId, vendor);
    }

    @Override
    public Vendor get(int vendorId) {
        return vendorRepository.get(vendorId);
    }

    @Override
//    @Transactional
    public Vendor create(Vendor vendor) {
        return vendorRepository.create(vendor);
    }

    @Override
    public void delete(int vendorId) {
        vendorRepository.delete(vendorId);
    }












//    ONE TO ONE starts
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
    public void addVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail) {
        vendorRepository.addVendorAndroidAppDetail(vendorId, androidAppDetail);
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
    public void addVendorGeoLocation(int vendorId, GeoLocation geoLocation) {
        vendorRepository.addVendorGeoLocation(vendorId, geoLocation);
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
    public void addVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {
        vendorRepository.addVendorDeliveryTiming(vendorId, deliveryTiming);
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
    public void addVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {
        vendorRepository.addVendorDeliveryCriteria(vendorId, deliveryCriteria);
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
    public void addVendorTaxDetails(int vendorId, TaxDetails taxDetails) {
        vendorRepository.addVendorTaxDetails(vendorId, taxDetails);
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
    public void addVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {
        vendorRepository.addVendorVendorStatus(vendorId, vendorStatus);
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

