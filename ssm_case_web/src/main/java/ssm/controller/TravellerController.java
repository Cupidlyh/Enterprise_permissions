package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.domain.Traveller;
import ssm.domain.UserInfo;
import ssm.service.ITravellerService;
import ssm.service.IUserService;

import java.util.List;

@Controller
@RequestMapping("/traveller")
public class TravellerController {

    @Autowired
    private ITravellerService travellerService;

    @RequestMapping("/findByIdAndAlter.do")
    public ModelAndView findByIdAndAlter(@RequestParam(name = "id", required = true) Integer travellerId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Traveller traveller = travellerService.findById(travellerId);
        mv.addObject("traveller",traveller);
        mv.setViewName("traveller-alter");
        return mv;
    }

    @RequestMapping("/alter.do")
    public String alter(Traveller traveller) throws Exception {
        travellerService.alter(traveller);
        return "redirect:findAll.do";
    }



    @RequestMapping("/save.do")
    public String save(Traveller traveller) throws Exception {
        travellerService.save(traveller);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Traveller> travellerList = travellerService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(travellerList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("travellerSize",size);
        mv.setViewName("traveller-page-list");
        return mv;
    }


}
