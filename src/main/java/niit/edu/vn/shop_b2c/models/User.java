package niit.edu.vn.shop_b2c.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String email;

    @Column
    String password;

    @Column
    String phone;

    @Column
    String address;

    @Column
    String fullname;

}
