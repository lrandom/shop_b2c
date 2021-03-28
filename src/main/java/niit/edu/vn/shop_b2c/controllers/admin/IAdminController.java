package niit.edu.vn.shop_b2c.controllers.admin;

import niit.edu.vn.shop_b2c.models.Role;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IAdminController {
    public String list(Model model);
    public String add(Model model);
    public String edit(Model model, Long id);
    public String doAdd(Role role, RedirectAttributes redirectAttributes);
    public String doEdit(Role role,RedirectAttributes redirectAttributes);
    public String delete();
}
