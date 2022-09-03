package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.IRoleDao;
import ssm.domain.Permission;
import ssm.domain.Role;
import ssm.service.IRoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(int roleId, Integer[] permissionIds) {
        for(int permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public void deleteRole_permissionById(Integer id) {
        roleDao.deleteRole_permissionById(id);
    }

    @Override
    public void deleteUsers_roleById(Integer id) {
        roleDao.deleteUsers_roleById(id);
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleDao.deleteRoleById(id);
    }
}
