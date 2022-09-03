-- 用户角色关联表
CREATE TABLE users_role(
userId INT,
roleId INT,
PRIMARY KEY(userId,roleId),
FOREIGN KEY (userId) REFERENCES users(id),
FOREIGN KEY (roleId) REFERENCES role(id)
);

INSERT INTO users_role VALUES(1, 1);

INSERT INTO users_role VALUES(1, 2);