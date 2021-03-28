package niit.edu.vn.shop_b2c.controllers.frontend;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null) {
            model.addAttribute("auth", auth);
        }
        return "frontend/home";
    }


    @GetMapping("/login")
    public String login(){
        return "frontend/login";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse resp){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null) {
          new SecurityContextLogoutHandler().logout(request,resp,auth);
        }
        return "redirect:/";
    }
}
