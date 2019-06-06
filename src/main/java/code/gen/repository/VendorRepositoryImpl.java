
package code.gen.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import code.gen.repository.mapper.VendorMapper;
import code.gen.entities.*;
import java.util.List;

@Repository
public class VendorRepositoryImpl implements VendorRepository {

    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public Vendor update(int vendorId, Vendor vendor) {
        try {
            return vendorMapper.update(vendorId, vendor);
        }
        catch (DataIntegrityViolationException dive) {
        //             this exception occurs if the length of the field is more than required.
            throw dive;
        }
        // TODO: 26/05/19 always add this catch block in the dao methods
        catch (DataAccessException e ) {
            throw e;
        }
    }

    @Override
    public Vendor get(int vendorId) {
        return vendorMapper.get(vendorId);
    }

    @Override
    public Vendor create(Vendor vendor) {
        try {
            vendorMapper.addVendorOwner(vendor.getOwner());
            vendorMapper.create(vendor);


        }
        catch (DuplicateKeyException dke) {
            throw dke;
        }
        catch (DataIntegrityViolationException dive) {
        //             this exception occurs if the length of the field is more than required.
            throw dive;
        }
        // TODO: 26/05/19 always add this catch block in the dao methods
        catch (DataAccessException e ) {
            throw e;
        }
        return vendor;
    }

    @Override
    public void delete(int vendorId) {

        Vendor vendor = vendorMapper.get(vendorId);
        // call all the unlink operations
        vendorMapper.unLinkVendorOwner(vendorId);
        vendorMapper.deleteVendorOwner(vendorId);

        vendorMapper.unLinkVendorShopAddress(vendorId);

        vendorMapper.unLinkVendorGeoLocation(vendorId);

        vendorMapper.unLinkVendorDeliveryCriteria(vendorId);

        vendorMapper.unLinkVendorTaxDetails(vendorId);

        vendorMapper.unLinkVendorVendorStatus(vendorId);

        for ( AndroidAppDetail var : vendor.getAndroidAppDetails()) {
            vendorMapper.unLinkVendorAndroidAppDetail(vendorId, var.getId());
        }
        for ( DeliveryTiming var : vendor.getDeliveryTimings()) {
            vendorMapper.unLinkVendorDeliveryTiming(vendorId, var.getId());
        }
        for ( DeliveryArea var : vendor.getDeliveryAreas()) {
            vendorMapper.unLinkVendorDeliveryArea(vendorId, var.getId());
        }
        for ( PaymentOption var : vendor.getPaymentOptions()) {
            vendorMapper.unLinkVendorPaymentOption(vendorId,  var.getId());
        }
        for ( DeliveryAgent var : vendor.getDeliveryAgents()) {
            vendorMapper.unLinkVendorDeliveryAgent(vendorId,  var.getId());
        }
        vendorMapper.delete(vendorId);
    }



    public void addVendorShopAddress(int vendorId, Address shopAddress) {
        vendorMapper.addVendorShopAddress(shopAddress);
        int id = shopAddress.getId();
        vendorMapper.linkVendorShopAddress(vendorId,  id);
    }

    public Address getVendorShopAddress(int vendorId) {
        return vendorMapper.getVendorShopAddress(vendorId);
    }

    public void deleteVendorShopAddress(int vendorId) {
        Address shopAddress = vendorMapper.getVendorShopAddress(vendorId);
        if(shopAddress == null) {
            return;
        }
        vendorMapper.unLinkVendorShopAddress(vendorId);
        vendorMapper.deleteVendorShopAddress(vendorId);
    }

    public void updateVendorShopAddress(int vendorId, Address shopAddress) {
        vendorMapper.updateVendorShopAddress(shopAddress);
    }



    public void linkVendorPaymentOption(int vendorId, int paymentOptionId) {
        vendorMapper.linkVendorPaymentOption(vendorId, paymentOptionId);
    }

    public void unLinkVendorPaymentOption(int vendorId, int paymentOptionId) {
        vendorMapper.unLinkVendorPaymentOption(vendorId, paymentOptionId);
    }




    public void addVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail) {

        vendorMapper.addVendorAndroidAppDetail(vendorId,  androidAppDetail);
    }

    public AndroidAppDetail getVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        return vendorMapper.getVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    public void deleteVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        vendorMapper.deleteVendorAndroidAppDetail(androidAppDetailId);
    }

    public void updateVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail) {
        vendorMapper.updateVendorAndroidAppDetail(vendorId, androidAppDetail);
    }

    public List<AndroidAppDetail> searchVendorAndroidAppDetails(int vendorId, String nameFilter, int page, int noOfResults) {
        return vendorMapper.getVendorAndroidAppDetails(vendorId);
    }
    public void linkVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        vendorMapper.linkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    public void unLinkVendorAndroidAppDetail(int vendorId, int androidAppDetailId) {
        vendorMapper.unLinkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }



    public void addVendorGeoLocation(int vendorId, GeoLocation geoLocation) {
        vendorMapper.addVendorGeoLocation(geoLocation);
        int id = geoLocation.getId();
        vendorMapper.linkVendorGeoLocation(vendorId,  id);
    }

    public GeoLocation getVendorGeoLocation(int vendorId) {
        return vendorMapper.getVendorGeoLocation(vendorId);
    }

    public void deleteVendorGeoLocation(int vendorId) {
        GeoLocation geoLocation = vendorMapper.getVendorGeoLocation(vendorId);
        if(geoLocation == null) {
            return;
        }
        vendorMapper.unLinkVendorGeoLocation(vendorId);
        vendorMapper.deleteVendorGeoLocation(vendorId);
    }

    public void updateVendorGeoLocation(int vendorId, GeoLocation geoLocation) {
        vendorMapper.updateVendorGeoLocation(geoLocation);
    }



    public void addVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {

        vendorMapper.addVendorDeliveryTiming(vendorId,  deliveryTiming);
    }

    public DeliveryTiming getVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        return vendorMapper.getVendorDeliveryTiming(vendorId, deliveryTimingId);
    }

    public void deleteVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        vendorMapper.deleteVendorDeliveryTiming(deliveryTimingId);
    }

    public void updateVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {
        vendorMapper.updateVendorDeliveryTiming(vendorId, deliveryTiming);
    }

    public List<DeliveryTiming> searchVendorDeliveryTimings(int vendorId, String nameFilter, int page, int noOfResults) {
        return vendorMapper.getVendorDeliveryTimings(vendorId);
    }
    public void linkVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        vendorMapper.linkVendorDeliveryTiming(vendorId, deliveryTimingId);
    }

    public void unLinkVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        vendorMapper.unLinkVendorDeliveryTiming(vendorId, deliveryTimingId);
    }



    public void addVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {
        int id = deliveryCriteria.getId();
        vendorMapper.linkVendorDeliveryCriteria(vendorId,  id);
    }

    public DeliveryCriteria getVendorDeliveryCriteria(int vendorId) {
        return vendorMapper.getVendorDeliveryCriteria(vendorId);
    }

    public void deleteVendorDeliveryCriteria(int vendorId) {
        DeliveryCriteria deliveryCriteria = vendorMapper.getVendorDeliveryCriteria(vendorId);
        if(deliveryCriteria == null) {
            return;
        }
        vendorMapper.unLinkVendorDeliveryCriteria(vendorId);
    }

    public void updateVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {
        vendorMapper.updateVendorDeliveryCriteria(deliveryCriteria);
    }


        public void linkVendorDeliveryArea(int vendorId, int deliveryAreaId) {
        vendorMapper.linkVendorDeliveryArea(vendorId, deliveryAreaId);
    }

    public void unLinkVendorDeliveryArea(int vendorId, int deliveryAreaId) {
        vendorMapper.unLinkVendorDeliveryArea(vendorId, deliveryAreaId);
    }


    public void addVendorTaxDetails(int vendorId, TaxDetails taxDetails) {
        vendorMapper.addVendorTaxDetails(taxDetails);
        int id = taxDetails.getId();
        vendorMapper.linkVendorTaxDetails(vendorId,  id);
    }

    public TaxDetails getVendorTaxDetails(int vendorId) {
        return vendorMapper.getVendorTaxDetails(vendorId);
    }

    public void deleteVendorTaxDetails(int vendorId) {
        TaxDetails taxDetails = vendorMapper.getVendorTaxDetails(vendorId);
        if(taxDetails == null) {
            return;
        }
        vendorMapper.unLinkVendorTaxDetails(vendorId);
        vendorMapper.deleteVendorTaxDetails(vendorId);
    }

    public void updateVendorTaxDetails(int vendorId, TaxDetails taxDetails) {
        vendorMapper.updateVendorTaxDetails(taxDetails);
    }


    public void addVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {
        int id = vendorStatus.getId();
        vendorMapper.linkVendorVendorStatus(vendorId,  id);
    }

    public VendorStatus getVendorVendorStatus(int vendorId) {
        return vendorMapper.getVendorVendorStatus(vendorId);
    }

    public void deleteVendorVendorStatus(int vendorId) {
        VendorStatus vendorStatus = vendorMapper.getVendorVendorStatus(vendorId);
        if(vendorStatus == null) {
            return;
        }
        vendorMapper.unLinkVendorVendorStatus(vendorId);
    }

    public void updateVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {
        vendorMapper.updateVendorVendorStatus(vendorStatus);
    }


        public void linkVendorDeliveryAgent(int vendorId, int deliveryAgentId) {
        vendorMapper.linkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }

    public void unLinkVendorDeliveryAgent(int vendorId, int deliveryAgentId) {
        vendorMapper.unLinkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }
}


