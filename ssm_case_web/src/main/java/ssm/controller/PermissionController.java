package ssm.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.domain.Permission;
import ssm.service.IPermissionServive;

import java.util.List;


@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionServive permissionServive;


    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionServive.findById(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionServive.save(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionServive.findAll(page,size);
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("permissionSize",size);
        mv.setViewName("permission-page-list");
        return mv;
    }

    @RequestMapping("/deletePermissionById.do")
    public String deletePermissionById(Integer id) {
        permissionServive.deleteRole_permissionById(id);
        permissionServive.deletePermissionById(id);
        return "redirect:findAll.do";
    }
}
