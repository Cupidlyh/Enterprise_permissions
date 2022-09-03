package ssm.service;

import ssm.domain.Permission;

import java.util.List;

public interface IPermissionServive {
    public List<Permission> findAll(int page,int size) throws Exception;

    void save(Permission permission) throws Exception;

    void deleteRole_permissionById(Integer id);

    void deletePermissionById(Integer id);

    Permission findById(Integer id) throws Exception;
}
