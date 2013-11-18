package biz.ezcom.spring.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import biz.ezcom.spring.mvc.vo.Programming;

public class ProgrammingValidator implements Validator {
    private Integer usernameLength;
    private Integer passwordLength;

    public Integer getUsernameLength() {
        return usernameLength;
    }

    public void setUsernameLength(Integer usernameLength) {
        this.usernameLength = usernameLength;
    }

    public Integer getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(Integer passwordLength) {
        this.passwordLength = passwordLength;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("UserValidator.supports()");
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Programming user = (Programming) target;
        String username = user.getUsername();
        if (username == null) {
            errors.rejectValue("username", "username.null.error", "用户名不能为空");
        } else if (username.length() != usernameLength) {
            Object[] args = new Object[] { usernameLength };
            errors.rejectValue("username", "username.length.error", args, "用户名长度必需为" + usernameLength);
        }
        Object[] args = new Object[] { usernameLength };
        String password = user.getPassword();
        if (password == null) {
            errors.rejectValue("password", "password.null.error", "密码不能为空");
        } else if (password.length() != passwordLength) {
            errors.rejectValue("password", "password.length.error", args, "密码长度必需为" + passwordLength);
        }
        String repassword = user.getRepassword();
        if (repassword == null) {
            errors.rejectValue("repassword", "repassword.null.error", "重复密码不能为空");
        } else if (repassword.length() != passwordLength) {
            errors.rejectValue("repassword", "repassword.length.error", args, "重复密码长度必需为" + passwordLength);
        } else if (!repassword.equals(password)) {
            errors.rejectValue("repassword", "repassword.repeat.error", "两次密码输入必需一致");
        }
    }
}
