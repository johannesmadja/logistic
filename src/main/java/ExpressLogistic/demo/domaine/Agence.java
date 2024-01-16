package ExpressLogistic.demo.domaine;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agence")
@Getter
@Setter
public class Agence {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id; 

    @Column()
    private String name;

    // @ManyToMany
    // @JoinTable(name = "agence_users", 
    // joinColumns = @JoinColumn(name = "agence_id", referencedColumnName = "id"), 
    // inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    // private List<User> managers;

    @OneToMany(mappedBy = "agences")
    private List<User> managers;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @Column()
    private Boolean valid;

}
