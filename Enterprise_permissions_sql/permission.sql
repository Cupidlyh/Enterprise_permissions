-- 资源权限表
CREATE TABLE permission(
id INT PRIMARY KEY AUTO_INCREMENT,
permissionName VARCHAR(50) ,
url VARCHAR(50)
);


INSERT INTO permission(permissionname,url) VALUES('user findAll', '/user/findAll.do');

INSERT INTO permission(permissionname,url) VALUES('user findById', '/user/findById.do');