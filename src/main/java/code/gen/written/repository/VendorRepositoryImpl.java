package code.gen.written.repository;

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
import code.gen.written.repository.mapper.VendorMapper;
import org.apache.ibatis.exceptions.IbatisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import code.gen.written.entities.*;
import java.util.List;

//@Repository
public class VendorRepositoryImpl implements VendorRepository {

    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public void update(int vendorId, Vendor vendor) {
        try {
            vendorMapper.update(vendorId, vendor);
        }
        catch (DataIntegrityViolationException dive) {
//             this exception occurs if the length of the field is more than required.
            throw dive;
        }
        // TODO: 26/05/19 always add this catch block in the dao methods
        catch (DataAccessException e ) {
            throw e;
        }
        catch (IbatisException e ) {
            throw e;
        }
    }

    @Override
    public Vendor get(int vendorId) {
        try {
            Vendor vendor = vendorMapper.get(vendorId);
            vendor.getShopAddress();

            return vendor;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    @Override
    public Vendor create(Vendor vendor) {
        try {
//            one to one
            vendorMapper.addVendorShopAddress(vendor.getShopAddress());
            vendorMapper.create(vendor);
//            one to many
            for(AndroidAppDetail a:  vendor.getAndroidAppDetails()) {
                vendorMapper.addVendorAndroidAppDetail(vendor.getId(), a);
            }
//            many to many
            for(DeliveryAgent da:  vendor.getDeliveryAgents()) {
                vendorMapper.addVendorDeliveryAgent(vendor.getId(), da);
                vendorMapper.linkVendorDeliveryAgent(vendor.getId(), da.getId());
            }

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
        // 1st delete all the oneToMany and manyToMany relationships
//        series of unlink operations

        vendorMapper.delete(vendorId);
    }


//    one to one
// TODO: 26/05/19
    public void addVendorShopAddress(int vendorId, Address shopAddress){
        vendorMapper.addVendorShopAddress(shopAddress);
        Integer shopAddressId = shopAddress.getId();
        vendorMapper.linkVendorShopAddress(vendorId, shopAddressId);
    }

    public Address getVendorShopAddress(int vendorId){
        return  vendorMapper.getVendorShopAddress(vendorId);
    }

    public void deleteVendorShopAddress(int vendorId){
        Address shopAddress = vendorMapper.getVendorShopAddress(vendorId);
        if(shopAddress == null) {
            return;
        }
        vendorMapper.unLinkVendorShopAddress(vendorId, null);
        vendorMapper.deleteVendorShopAddress(shopAddress.getId());
    }

    public void updateVendorShopAddress(int vendorId, Address shopAddress){
        vendorMapper.updateVendorShopAddress(vendorId, shopAddress);
    }

    @Override
    public int addVendorPaymentOption(int vendorId, PaymentOption paymentOption) {
        return 0;
    }

    @Override
    public PaymentOption getVendorPaymentOption(int vendorId, int paymentOptionId) {
        return null;
    }

    @Override
    public void updateVendorPaymentOption(int vendorId, PaymentOption paymentOption) {

    }

    @Override
    public void deleteVendorPaymentOption(int vendorId, int paymentOptionId) {

    }

    @Override
    public List<PaymentOption> searchVendorPaymentOptions(int vendorId, String nameFilter, int page, int noOfResults) {
        return null;
    }

    @Override
    public void linkVendorPaymentOption(int vendorId, int paymentOptionId) {

    }

    @Override
    public void unLinkVendorPaymentOption(int vendorId, int paymentOptionId) {

    }
//    one to one




//    one to many
    public int addVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail){
//        this takes care of linking as well
        vendorMapper.addVendorAndroidAppDetail(vendorId, androidAppDetail);

        return vendorMapper.addVendorAndroidAppDetail(vendorId, androidAppDetail);
    }

    public AndroidAppDetail getVendorAndroidAppDetail(int vendorId, int androidAppDetailId){
        return vendorMapper.getVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    public void updateVendorAndroidAppDetail(int vendorId, AndroidAppDetail androidAppDetail){
        vendorMapper.updateVendorAndroidAppDetail(vendorId, androidAppDetail);
    }

    public void deleteVendorAndroidAppDetail(int vendorId, int androidAppDetailId){
        vendorMapper.deleteVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    public List<AndroidAppDetail> searchVendorAndroidAppDetails(int vendorId, String nameFilter, int page, int noOfResults){
        return vendorMapper.searchVendorAndroidAppDetails( vendorId,  nameFilter,  page,  noOfResults);
    }

    public void linkVendorAndroidAppDetail(int vendorId, int androidAppDetailId){
        vendorMapper.linkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    public void unLinkVendorAndroidAppDetail(int vendorId, int androidAppDetailId){
        vendorMapper.unLinkVendorAndroidAppDetail(vendorId, androidAppDetailId);
    }

    @Override
    public int addVendorGeoLocation(int vendorId, GeoLocation geoLocation) {
        return 0;
    }

    @Override
    public GeoLocation getVendorGeoLocation(int vendorId) {
        return null;
    }

    @Override
    public void deleteVendorGeoLocation(int vendorId) {

    }

    @Override
    public void updateVendorGeoLocation(int vendorId, GeoLocation geoLocation) {

    }

    @Override
    public int addVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {
        return 0;
    }

    @Override
    public DeliveryTiming getVendorDeliveryTiming(int vendorId, int deliveryTimingId) {
        return null;
    }

    @Override
    public void updateVendorDeliveryTiming(int vendorId, DeliveryTiming deliveryTiming) {

    }

    @Override
    public void deleteVendorDeliveryTiming(int vendorId, int deliveryTimingId) {

    }

    @Override
    public List<DeliveryTiming> searchVendorDeliveryTimings(int vendorId, String nameFilter, int page, int noOfResults) {
        return null;
    }

    @Override
    public void linkVendorDeliveryTiming(int vendorId, int deliveryTimingId) {

    }

    @Override
    public void unLinkVendorDeliveryTiming(int vendorId, int deliveryTimingId) {

    }

    @Override
    public int addVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {
        return 0;
    }

    @Override
    public DeliveryCriteria getVendorDeliveryCriteria(int vendorId) {
        return null;
    }

    @Override
    public void deleteVendorDeliveryCriteria(int vendorId) {

    }

    @Override
    public void updateVendorDeliveryCriteria(int vendorId, DeliveryCriteria deliveryCriteria) {

    }

    @Override
    public int addVendorDeliveryArea(int vendorId, DeliveryArea deliveryArea) {
        return 0;
    }

    @Override
    public DeliveryArea getVendorDeliveryArea(int vendorId, int deliveryAreaId) {
        return null;
    }

    @Override
    public void updateVendorDeliveryArea(int vendorId, DeliveryArea deliveryArea) {

    }

    @Override
    public void deleteVendorDeliveryArea(int vendorId, int deliveryAreaId) {

    }

    @Override
    public List<DeliveryArea> searchVendorDeliveryAreas(int vendorId, String nameFilter, int page, int noOfResults) {
        return null;
    }

    @Override
    public void linkVendorDeliveryArea(int vendorId, int deliveryAreaId) {

    }

    @Override
    public void unLinkVendorDeliveryArea(int vendorId, int deliveryAreaId) {

    }

    @Override
    public int addVendorTaxDetails(int vendorId, TaxDetails taxDetails) {
        return 0;
    }

    @Override
    public TaxDetails getVendorTaxDetails(int vendorId) {
        return null;
    }

    @Override
    public void deleteVendorTaxDetails(int vendorId) {

    }

    @Override
    public void updateVendorTaxDetails(int vendorId, TaxDetails taxDetails) {

    }

    @Override
    public int addVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {
        return 0;
    }

    @Override
    public VendorStatus getVendorVendorStatus(int vendorId) {
        return null;
    }

    @Override
    public void deleteVendorVendorStatus(int vendorId) {

    }

    @Override
    public void updateVendorVendorStatus(int vendorId, VendorStatus vendorStatus) {

    }

//    one to many

//    many to many

    public int addVendorDeliveryAgent(int vendorId, DeliveryAgent deliveryAgent){
        vendorMapper.addVendorDeliveryAgent(vendorId, deliveryAgent);
        vendorMapper.linkVendorDeliveryAgent(vendorId, deliveryAgent.getId());
        return deliveryAgent.getId();
    }

    public DeliveryAgent getVendorDeliveryAgent(int vendorId, int deliveryAgentId){
        return vendorMapper.getVendorDeliveryAgent(vendorId, deliveryAgentId);
    }

    public void updateVendorDeliveryAgent(int vendorId, DeliveryAgent deliveryAgent){
        vendorMapper.updateVendorDeliveryAgent(vendorId, deliveryAgent);
    }

    public void deleteVendorDeliveryAgent(int vendorId, int deliveryAgentId){
        vendorMapper.deleteVendorDeliveryAgent(vendorId, deliveryAgentId);
        vendorMapper.unLinkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }

    public List<DeliveryAgent> searchVendorDeliveryAgents(int vendorId, String nameFilter, int page, int noOfResults){
        return  vendorMapper.searchVendorDeliveryAgents(vendorId, nameFilter, page, noOfResults);
    }

    public void linkVendorDeliveryAgent(int vendorId, int deliveryAgentId){
        vendorMapper.linkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }

    public void unLinkVendorDeliveryAgent(int vendorId, int deliveryAgentId){
        vendorMapper.unLinkVendorDeliveryAgent(vendorId, deliveryAgentId);
    }

//    many to many








}
