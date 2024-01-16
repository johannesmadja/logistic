package ExpressLogistic.demo.domaine;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import ExpressLogistic.demo.domaine.enumeration.InterventionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "intervention")
@Getter
@Setter
public class Intervention {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column()
    private String name;

    @Enumerated(EnumType.STRING)
    private InterventionStatus status;

    @Column()
    private String orderId; 

    @Column()
    private Number total;

    @ManyToOne()
    @JoinColumn(name = "expert")
    private User expert;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
}
