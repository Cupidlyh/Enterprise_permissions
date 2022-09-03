CREATE TABLE product(
id INT PRIMARY KEY AUTO_INCREMENT,
productNum VARCHAR(20) NOT NULL,
productName VARCHAR(20),
cityName VARCHAR(20),
DepartureTime TIMESTAMP,
productPrice DOUBLE,
productDesc VARCHAR(500),
productStatus INT,
CONSTRAINT product UNIQUE (id, productNum)
);


-- STR_TO_DATE函数是字符串转日期
INSERT INTO PRODUCT (productnum, productname, cityname, departuretime, productprice,productdesc, productstatus)
VALUES ('itcast-002', '北京三日游', '北京', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 1200, '不错的旅行', 1);
INSERT INTO PRODUCT (productnum, productname, cityname, departuretime, productprice,productdesc, productstatus)
VALUES ('itcast-003', '上海五日游', '上海', STR_TO_DATE('2018-04-25 14:30:00',"%Y-%m-%d %H:%i:%s"), 1800, '魔都我来了', 0);
INSERT INTO PRODUCT (productnum, productname, cityname, departuretime, productprice,productdesc, productstatus)
VALUES ('itcast-001', '北京三日游', '北京', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 1200, '不错的旅行', 1);

