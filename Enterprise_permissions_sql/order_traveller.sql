CREATE TABLE order_traveller(
orderId INT,
travellerId INT,
PRIMARY KEY (orderId,travellerId),
FOREIGN KEY (orderId) REFERENCES orders(id),
FOREIGN KEY (travellerId) REFERENCES traveller(id)
);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (1, 1);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (3, 1);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (9, 2);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (7, 2);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (2, 1);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (6, 2);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (4, 1);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (8, 2);

INSERT INTO ORDER_TRAVELLER (orderid, travellerid)
VALUES (5, 2);

