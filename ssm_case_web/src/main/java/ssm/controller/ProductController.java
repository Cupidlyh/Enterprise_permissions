package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.domain.Orders;
import ssm.domain.Product;
import ssm.service.IProductService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findByIdAndAlter.do")
    public ModelAndView findByIdAndAlter(@RequestParam(name = "id", required = true) Integer productId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("product", product);
        mv.setViewName("product-alter");
        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer productId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("product", product);
        mv.setViewName("product-show");
        return mv;
    }

    // 产品修改
    @RequestMapping("/alter.do")
    public String alter(Product product) throws Exception {
        productService.alter(product);
        return "redirect:findAll.do";
    }


    // 产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }


    // 查询全部产品
    @RequestMapping("/findAll.do")
//    @RolesAllowed("ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(ps);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("productSize",size);
        mv.setViewName("product-page-list");
        return mv;
    }
}
