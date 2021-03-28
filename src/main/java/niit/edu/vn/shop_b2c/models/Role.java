package niit.edu.vn.shop_b2c.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "code")
    String code;
}
