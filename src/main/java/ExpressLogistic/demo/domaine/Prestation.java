package ExpressLogistic.demo.domaine;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "prestation")
public class Prestation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column()
    private String name; 

    @Column()
    private String codeString; 

    @Column()
    private Number price;

    @Column()
    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private Date description;
}
