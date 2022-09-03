-- 角色权限关联表
CREATE TABLE role_permission(
permissionId INT,
roleId INT,
PRIMARY KEY(permissionId,roleId),
FOREIGN KEY (permissionId) REFERENCES permission(id),
FOREIGN KEY (roleId) REFERENCES role(id)
);

INSERT INTO role_permission VALUES(1, 1);
INSERT INTO role_permission VALUES(2, 1);
INSERT INTO role_permission VALUES(1, 2);