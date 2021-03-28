package niit.edu.vn.shop_b2c.controllers.admin;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IAdminController<T>{
    public String list(Model model, int page);
    public String add(Model model);
    public String edit(Model model, Long id);
    public String doAdd(T obj, RedirectAttributes redirectAttributes);
    public String doEdit(T obj,RedirectAttributes redirectAttributes);
    public String delete();
}
