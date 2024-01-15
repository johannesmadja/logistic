package ExpressLogistic.demo.domaine;

import ExpressLogistic.demo.domaine.enumeration.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column()
    private String name;

    @Column()
    private String lastNane; 

    @Column()
    private String mail;

    @Column()
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
