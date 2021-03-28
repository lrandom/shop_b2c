package niit.edu.vn.shop_b2c.controllers.admin;

import niit.edu.vn.shop_b2c.models.Role;
import niit.edu.vn.shop_b2c.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/role")
public class RoleController implements IAdminController {
    @Autowired
    RoleService roleService;

    @Override
    public String list(Model model) {

        return null;
    }

    @Override
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("obj", new Role());
        return "admin/role/add";
    }

    @Override
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        model.addAttribute("obj", roleService.getService().getById(id));
        return "admin/role/edit";
    }

    @Override
    @PostMapping("/do-add")
    public String doAdd(Role role, RedirectAttributes redirectAttributes) {
        if (roleService.getService().save(role)) {
            redirectAttributes.addFlashAttribute("success", "Thêm thành công");
        } else {
            redirectAttributes.addFlashAttribute("error", "Thêm thất bại");
        }

        return "redirect:/admin/role/add";
    }

    @Override
    @PostMapping("/do-edit")
    public String doEdit(Role role, RedirectAttributes redirectAttributes) {
        if (roleService.getService().save(role)) {
            redirectAttributes.addFlashAttribute("success", "Sửa thành công");
        } else {
            redirectAttributes.addFlashAttribute("error", "Sửa thất bại");
        }

        return "redirect:/admin/role/edit?id"+role.getId();
    }

    @Override
    public String delete() {
        return null;
    }
}
