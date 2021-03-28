package niit.edu.vn.shop_b2c.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @GetMapping("/layout")
     public String getLayout(){
         return "admin/layout";
     }
}
