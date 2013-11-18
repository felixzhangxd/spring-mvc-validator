package biz.ezcom.spring.mvc.vo;

import java.util.Locale;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Declare {
    @NotNull(message = "{username.null.error}")
    @Length(min = 5, max = 5, message = "{username.length.error}")
    private String username;
    @NotNull(message = "{password.null.error}")
    @Length(min = 5, max = 5, message = "{password.length.error}")
    private String password;
    @NotNull(message = "{repassword.null.error}")
    @Length(min = 5, max = 5, message = "{repassword.length.error}")
    private String repassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
    }
}
