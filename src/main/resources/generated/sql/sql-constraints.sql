ALTER TABLE vendor ADD FOREIGN KEY (owner) REFERENCES person (id);
CREATE INDEX vendor_person_fk ON vendor (owner);

ALTER TABLE vendor ADD FOREIGN KEY (shop_address) REFERENCES address (id);
CREATE INDEX vendor_address_fk ON vendor (shop_address);

ALTER TABLE vendor ADD FOREIGN KEY (geo_location) REFERENCES geo_location (id);
CREATE INDEX vendor_geo_location_fk ON vendor (geo_location);

ALTER TABLE vendor ADD FOREIGN KEY (delivery_criteria) REFERENCES delivery_criteria (id);
CREATE INDEX vendor_delivery_criteria_fk ON vendor (delivery_criteria);

ALTER TABLE vendor ADD FOREIGN KEY (tax_details) REFERENCES tax_details (id);
CREATE INDEX vendor_tax_details_fk ON vendor (tax_details);

ALTER TABLE vendor ADD FOREIGN KEY (vendor_status) REFERENCES vendor_status (id);
CREATE INDEX vendor_vendor_status_fk ON vendor (vendor_status);

CREATE UNIQUE INDEX vendor_ukey ON vendor (code);

ALTER TABLE android_app_detail ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
CREATE INDEX android_app_detail_vendor_fk ON android_app_detail (vendor_id);

ALTER TABLE vendor_delivery_agent ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
CREATE INDEX vendor_delivery_agent_vendor_fk ON vendor_delivery_agent (vendor_id);

ALTER TABLE vendor_delivery_agent ADD FOREIGN KEY (delivery_agent_id) REFERENCES delivery_agent (id);
CREATE INDEX vendor_delivery_agent_delivery_agent_fk ON vendor_delivery_agent (delivery_agent_id);

ALTER TABLE delivery_area ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
CREATE INDEX delivery_area_vendor_fk ON delivery_area (vendor_id);

ALTER TABLE delivery_timing ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
CREATE INDEX delivery_timing_vendor_fk ON delivery_timing (vendor_id);

ALTER TABLE vendor_payment_option ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
CREATE INDEX vendor_payment_option_vendor_fk ON vendor_payment_option (vendor_id);

ALTER TABLE vendor_payment_option ADD FOREIGN KEY (payment_option_id) REFERENCES payment_option (id);
CREATE INDEX vendor_payment_option_payment_option_fk ON vendor_payment_option (payment_option_id);

