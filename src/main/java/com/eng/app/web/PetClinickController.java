package com.eng.app.web;

import com.eng.app.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetClinickController {

    @Autowired
    PetClinicService petClinicService;


    @RequestMapping("/owners")
    public ModelAndView getOwners() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners", petClinicService.findOwners());
        mav.setViewName("owners");
        return mav;
    }


    @RequestMapping("/pcs")
    @ResponseBody
    public String welcome(){
        return "Welcome to PetClinic World!";
    }


}
