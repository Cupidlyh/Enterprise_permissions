package ssm.dao;

import org.apache.ibatis.annotations.*;
import ssm.domain.Role;
import ssm.domain.UserInfo;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where id in (select userId from users_role where roleId=#{roleId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public List<UserInfo> findUsersByRoleId(int roleId) throws Exception;


    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(int id) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(int userId) throws Exception;

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);

    @Select("delete from users_role where userId=#{id}")
    void deleteUsers_roleById(Integer id);

    @Delete("delete from users where id=#{id}")
    void deleteUserById(Integer id);

    @Select("select * from users where id like CONCAT('%',#{information},'%') or email like CONCAT('%',#{information},'%') or username like CONCAT('%',#{information},'%') or phoneNum like CONCAT('%',#{information},'%')")
    List<UserInfo> findByInformation(String information) throws Exception;
}
