package biz.ezcom.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import biz.ezcom.spring.mvc.vo.Declare;

@Controller
@RequestMapping(value = { "/declare" })
public class DeclareValidatorController {
    
    @RequestMapping(value = { "/input" }, method={RequestMethod.GET})
    public String input(@ModelAttribute(value = "user") Declare user) {
        return "/declare/input";
    }
    @RequestMapping(value = { "/submit" }, method={RequestMethod.POST})
    public String input(@ModelAttribute(value = "user") @Valid Declare user, Errors errors) {
        if(errors.hasErrors()) {
            return "/declare/input";
        }
        return "/declare/submit";
    }
}
