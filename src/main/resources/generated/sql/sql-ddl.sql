CREATE TABLE vendor
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    code varchar(50)  ,
    name varchar(10) NOT NULL ,
    email varchar(10)  ,
    owner int unsigned NOT NULL ,
    shop_address int unsigned  
);


CREATE TABLE address
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    line1 varchar(250)  ,
    line2 varchar(250)  ,
    area varchar(10)  ,
    city varchar(10)  ,
    pin_code int unsigned  ,
    state varchar(10)  ,
    country varchar(10)  
);


CREATE TABLE tax_details
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    pan_number varchar(10)  ,
    gst_number varchar(10)  
);


CREATE TABLE android_app_detail
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    android_token varchar(250)  
);


CREATE TABLE geo_location
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    geo_location varchar(250)  
);


CREATE TABLE delivery_agent
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(10) NOT NULL ,
    last_name varchar(10) NOT NULL 
);


CREATE TABLE person
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(10)  ,
    last_name varchar(10)  ,
    middle_name varchar(10)  ,
    mobile_number int(10) unsigned  ,
    email varchar(10) NOT NULL 
);


CREATE TABLE delivery_area
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    pin_code int unsigned NOT NULL 
);


CREATE TABLE vendor_status
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    status_name varchar(10)  
);


CREATE TABLE delivery_timing
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    start_time DATETIME NOT NULL ,
    end_time DATETIME NOT NULL 
);


CREATE TABLE payment_option
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    name varchar(10)  ,
    description varchar(250)  
);


CREATE TABLE delivery_criteria
(
    id int unsigned PRIMARY KEY AUTO_INCREMENT,
    name varchar(10)  ,
    description varchar(250)  
);


