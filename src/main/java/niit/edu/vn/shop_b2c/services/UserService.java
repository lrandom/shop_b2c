package niit.edu.vn.shop_b2c.services;

import niit.edu.vn.shop_b2c.models.Role;
import niit.edu.vn.shop_b2c.models.User;
import niit.edu.vn.shop_b2c.respository.RoleRepo;
import niit.edu.vn.shop_b2c.respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    RoleService roleService;

    public AbService<User, UserRepo> getService() {
        return new AbService<>(this.userRepo);
    }

    public boolean save(User user) {
        try {
            User saveUser = new User();
            saveUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            saveUser.setFullName(user.getFullName());
            saveUser.setAddress(user.getAddress());
            saveUser.setEmail(user.getEmail());
            saveUser.setPhone(user.getPhone());

            Role role = roleService.getService().getById(user.getRoleId());
            HashSet<Role> roles = new HashSet<>();
            roles.add(role);

            saveUser.setRoles(roles);
            userRepo.save(saveUser);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
