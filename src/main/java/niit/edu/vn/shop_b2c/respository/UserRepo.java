package niit.edu.vn.shop_b2c.respository;

import niit.edu.vn.shop_b2c.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User,Long> {
    User findByEmail(String email);
}
