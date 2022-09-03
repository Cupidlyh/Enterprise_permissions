CREATE TABLE traveller(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(20),
sex VARCHAR(10),
phoneNum VARCHAR(20),
credentialsType INT,
credentialsNum VARCHAR(30),
travellerType INT
);


INSERT INTO TRAVELLER (id, NAME, sex, phonenum, credentialstype, credentialsnum, travellertype)
VALUES (1, '张龙', '男', '13333333333', 0,'123456789009876543', 0);

INSERT INTO TRAVELLER (id, NAME, sex, phonenum, credentialstype, credentialsnum, travellertype)
VALUES (2, '张小龙', '男', '15555555555', 0,'987654321123456789', 1);


