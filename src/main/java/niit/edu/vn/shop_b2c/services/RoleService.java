package niit.edu.vn.shop_b2c.services;

import niit.edu.vn.shop_b2c.models.Role;
import niit.edu.vn.shop_b2c.respository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleService {
    /*    @Autowired
        RoleRepo roleRepo;

        public Role getById(Long id) {
            return roleRepo.findById(id).get();
        }

        public boolean save(Role role) {
            try {
                roleRepo.save(role);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        public ArrayList<Role> getPaginate(int page) {
            ArrayList roles = new ArrayList<Role>();
            Iterable it = roleRepo.findAll(PageRequest.of(page - 1, 10));
            for (Object role : it
            ) {
                roles.add((Role) role);
            }
            return roles;
        }*/
    @Autowired
    private RoleRepo roleRepo;

    public AbService<Role, RoleRepo> getService() {
        return new AbService<>(this.roleRepo);
    }
}
