package com.example.city_transport.controllers;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @Autowired
    private HttpSessionBean httpSessionBean;
    @PostMapping("/login/authorization")
    public String login(@RequestParam String name,
                        @RequestParam String password) throws SQLException {
            try {
                httpSessionBean.getConnection().close();
                httpSessionBean.setConnection(loginService.getConnection(name, password));
                httpSessionBean.setId(loginService.getUserId(name, httpSessionBean.getConnection()));
                httpSessionBean.setRole(loginService.getRole(name, httpSessionBean.getConnection()));
                return "redirect:/";
            } catch (SQLException e){
                httpSessionBean.setConnection(loginService.getConnection("guest", "guest"));
                httpSessionBean.setId(0);
                httpSessionBean.setRole("guest");
                return "loginError";
            }
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout() throws SQLException {
        httpSessionBean.getConnection().close();
        httpSessionBean.setConnection(loginService.getConnection("guest", "guest"));
        httpSessionBean.setId(0);
        httpSessionBean.setRole("guest");
        return "redirect:/";
    }
}
