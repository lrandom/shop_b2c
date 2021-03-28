package niit.edu.vn.shop_b2c.controllers.admin;

import niit.edu.vn.shop_b2c.models.Role;
import niit.edu.vn.shop_b2c.models.User;
import niit.edu.vn.shop_b2c.services.RoleService;
import niit.edu.vn.shop_b2c.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/user")
public class UserController implements IAdminController<User> {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public String list(Model model, int page) {
        return null;
    }

    @Override
    @GetMapping("/add")
    public String add(Model model) {
        ArrayList<Role> roles = roleService.getService().getAll();

        model.addAttribute("listRole", roles);
        model.addAttribute("obj", new User());
        return "admin/user/add";
    }

    @Override
    public String edit(Model model, Long id) {
        return null;
    }

    @Override
    @PostMapping("/do-add")
    public String doAdd(User user, RedirectAttributes redirectAttributes) {
        //user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        if (userService.save(user)) {
            redirectAttributes.addFlashAttribute("success", "Thêm thành công");
        } else {
            redirectAttributes.addFlashAttribute("error", "Thêm thất bại");
        }

        return "redirect:/admin/user/add";
    }

    @Override
    public String doEdit(User user, RedirectAttributes redirectAttributes) {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}
