package ssm.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ssm.domain.Role;
import ssm.domain.UserInfo;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll(int page,int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;


    UserInfo findById(int id) throws Exception;

    List<Role> findOtherRoles(int userId) throws Exception;

    void addRoleToUser(int userId, Integer[] roleIds);

    void deleteUsers_roleById(Integer id);

    void deleteUserById(Integer id);


    List<UserInfo> findByInformation(Integer page, Integer size, String information) throws Exception;
}
