create database  Cars3 charset=utf8;

use cars3;
/* Drop Tables */

DROP TABLE CAR;

/* Create Tables */

CREATE TABLE CAR
(
	CARID INT NOT NULL AUTO_INCREMENT,
	PINPAIMING VARCHAR(20),
	XILIE VARCHAR(20),
	GONGLISHU INT,
	YANSE VARCHAR(20),
	SHOUJIA INT,
	
	PRIMARY KEY (CARID)
) charset=utf8;



