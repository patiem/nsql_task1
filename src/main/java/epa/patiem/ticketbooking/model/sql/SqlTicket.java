package epa.patiem.ticketbooking.model.sql;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Data
@Getter
@Setter
@Entity
@Table(name = "tickets")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SqlTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SqlUser user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private SqlEvent event;

    @Column(name = "place", nullable = false)
    private Integer place;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private SqlCategory category;

    public SqlTicket() {
    }

    public SqlTicket(Long id, SqlUser user, SqlEvent event, int place, SqlCategory category) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.place = place;
        this.category = category;
    }

    public SqlTicket(SqlUser user, SqlEvent sqlEvent, int place, SqlCategory category) {
        this.user = user;
        this.event = sqlEvent;
        this.place = place;
        this.category = category;
    }
}
