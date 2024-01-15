package ExpressLogistic.demo.domaine;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; 

    @Column()
    private String name;

    @OneToMany
    private User manager;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @Column()
    private Boolean valid;

}
