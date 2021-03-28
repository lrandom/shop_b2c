package niit.edu.vn.shop_b2c.services;

import niit.edu.vn.shop_b2c.models.Role;
import niit.edu.vn.shop_b2c.models.User;
import niit.edu.vn.shop_b2c.respository.RoleRepo;
import niit.edu.vn.shop_b2c.respository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepo userRepo;

    public AbService<User,UserRepo> getService(){
        return new AbService<>(this.userRepo);
    }
}
