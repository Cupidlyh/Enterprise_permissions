package ssm.service;

import ssm.domain.Permission;
import ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll(int page,int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(int roleId) throws Exception;

    List<Permission> findOtherPermission(int roleId) throws Exception;

    void addPermissionToRole(int roleId, Integer[] permissionIds);

    void deleteRole_permissionById(Integer id);

    void deleteUsers_roleById(Integer id);

    void deleteRoleById(Integer id);
}
