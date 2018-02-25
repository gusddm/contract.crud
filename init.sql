CREATE DATABASE IF NOT EXISTS contract_db;

CREATE TABLE IF NOT EXISTS contract_db.profile (
  id           BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name 		   varchar(60) not null,
  company  	   varchar(60) not null,
  image 	   varchar(60) not null,
  email		   varchar(60) not null,
  birthdate    DATETIME NOT NULL,
  phone_number varchar(60) not null,
  created_at   DATETIME NOT NULL,
  updated_at   DATETIME NOT NULL

);

CREATE TABLE IF NOT EXISTS contract_db.address (
  id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  profile_id  BIGINT UNSIGNED not null,
  address 	  varchar(90) not null,  
  city 		  varchar(60) not null,
  state		  varchar(30) not null,
  postal_code varchar(20) not null
);