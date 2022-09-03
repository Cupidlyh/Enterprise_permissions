package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.domain.Permission;
import ssm.domain.Role;
import ssm.domain.UserInfo;
import ssm.service.IRoleService;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    
    @Autowired
    private IRoleService roleService;


    //给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) Integer roleId, @RequestParam(name = "ids", required = true) Integer[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

    // 根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) Integer roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 根据roleId查询role
        Role role = roleService.findById(roleId);
        // 根据roleId查询可以添加的权限
        List<Permission> otherPermission = roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermission);
        mv.setViewName("role-permission-add");
        return mv;
    }



    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }
    
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("roleSize",size);
        mv.setViewName("role-page-list");
        return mv;
    }

    @RequestMapping("/deleteRoleById")
    public String deleteRoleById(Integer id) {
        roleService.deleteRole_permissionById(id);
        roleService.deleteUsers_roleById(id);
        roleService.deleteRoleById(id);
        return "redirect:findAll.do";
    }

}
