package epa.patiem.ticketbooking.model.sql;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Setter
@Getter
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


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SqlTicket sqlTicket = (SqlTicket) o;
        return Objects.equals(id, sqlTicket.id) && Objects.equals(user, sqlTicket.user) && Objects.equals(event, sqlTicket.event) && Objects.equals(place, sqlTicket.place) && category == sqlTicket.category;
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    public int hashCode() {
        return Objects.hash(id, user, event, place, category);
    }

    /**
     * To string string.
     *
     * @return the string
     */
    public String toString() {
        return "{" +
                "'id' : " + id +
                ", 'userId' : " + user.getId() +
                ", 'eventId' : " + event.getId() +
                ", 'place' : " + place +
                ", 'category' : '" + category +
                "'}";
    }
}
