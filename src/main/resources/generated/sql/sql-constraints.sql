ALTER TABLE vendor ADD FOREIGN KEY (owner) REFERENCES person (id);
CREATE INDEX vendor_person_fk ON vendor (owner);

ALTER TABLE vendor ADD FOREIGN KEY (shop_address) REFERENCES address (id);
CREATE INDEX vendor_address_fk ON vendor (shop_address);

CREATE UNIQUE INDEX vendor_ukey ON vendor (code);

