package biz.ezcom.spring.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import biz.ezcom.spring.mvc.validator.ProgrammingValidator;
import biz.ezcom.spring.mvc.vo.Programming;

@Controller
@RequestMapping(value = { "/programming" })
public class ProgrammingValidatorController {
    @Resource
    private ProgrammingValidator programmingValidator;
    
    @RequestMapping(value = { "/input" }, method={RequestMethod.GET})
    public String input(@ModelAttribute(value = "user") Programming user) {
        return "/programming/input";
    }
    @RequestMapping(value = { "/submit" }, method={RequestMethod.POST})
    public String input(@ModelAttribute(value = "user") Programming user, Errors errors) {
        programmingValidator.validate(user, errors);
        if(errors.hasErrors()) {
            return "/programming/input";
        }
        return "/programming/submit";
    }
}
