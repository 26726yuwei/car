create database  cars2 charset=utf8;

use cars2;
/* Drop Tables */

DROP TABLE CAR;




/* Create Tables */

CREATE TABLE CAR
(
	CARID INT NOT NULL AUTO_INCREMENT,
	PINPAIMING VARCHAR(20),
	XIELIE VARCHAR(20),
	GONGLISHU INT,
	YANSE VARCHAR(20),
	SHOUJIA INT,
	NIANFEN VARCHAR(20),
	SUOZAIDI VARCHAR(20),
	TUPIAN VARCHAR(200),
	PRIMARY KEY (CARID)
) charset=utf8;



