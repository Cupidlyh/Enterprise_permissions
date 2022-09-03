CREATE TABLE orders(
id INT PRIMARY KEY AUTO_INCREMENT,
orderNum VARCHAR(20) NOT NULL UNIQUE,
orderTime TIMESTAMP,
peopleCount INT,
orderDesc VARCHAR(500),
payType INT,
orderStatus INT,
productId INT,
FOREIGN KEY (productId) REFERENCES product(id)
);



INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (1, '12345', STR_TO_DATE('2018-03-02 12:00:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 1);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (2, '54321', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 1);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (3, '67890', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 2);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (4, '98765', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 2);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (5, '11111', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 2);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (6, '22222', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 2);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (7, '33333', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 3);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (8, '44444', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 3);

INSERT INTO ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus,productid)
VALUES (9, '55555', STR_TO_DATE('2018-10-10 10:10:00',"%Y-%m-%d %H:%i:%s"), 2, '没什么', 0, 1, 3);