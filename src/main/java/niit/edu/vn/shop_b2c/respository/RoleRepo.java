package niit.edu.vn.shop_b2c.respository;

import niit.edu.vn.shop_b2c.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends PagingAndSortingRepository<Role,Long> {

}
