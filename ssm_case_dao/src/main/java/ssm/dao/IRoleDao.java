package ssm.dao;

import org.apache.ibatis.annotations.*;
import ssm.domain.Permission;
import ssm.domain.Role;

import java.util.List;

public interface IRoleDao {


    @Select("select * from role where id in (select roleId from role_permission where permissionId=#{permissionId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "users",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IUserDao.findUsersByRoleId"))
    })
    public List<Role> findRoleByPermissionId(int permissionId) throws Exception;


    //  根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(int roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

    @Delete("delete from role_permission where roleId=#{id}")
    void deleteRole_permissionById(Integer id);

    @Delete("delete from users_role where roleId=#{id}")
    void deleteUsers_roleById(Integer id);

    @Delete("delete from role where id=#{id}")
    void deleteRoleById(Integer id);
}
