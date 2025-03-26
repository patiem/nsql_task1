package epa.patiem.ticketbooking.model.sql;

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

/**
 * The type Ticket.
 */
@Entity
@Table(name = "tickets")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SqlTicket {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The User entity.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private SqlUser user;

    /**
     * The Event entity.
     */
    @ManyToOne
    @JoinColumn(name = "event_id")
    private SqlEvent event;

    /**
     * The Place.
     */
    @Column(name = "place", nullable = false)
    private Integer place;

    /**
     * The SqlCategory.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private SqlCategory category;

    /**
     * Instantiates a new Ticket.
     */
    public SqlTicket() {
    }

    /**
     * Instantiates a new Ticket.
     *
     * @param id       the id
     * @param user     the user entity
     * @param event    the event entity
     * @param place    the place
     * @param category the category
     */
    public SqlTicket(Long id, SqlUser user, SqlEvent event, int place, SqlCategory category) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.place = place;
        this.category = category;
    }

    /**
     * Instantiates a new Ticket.
     *
     * @param user     the user entity
     * @param sqlEvent    the event entity
     * @param place    the place
     * @param category the category
     */
    public SqlTicket(SqlUser user, SqlEvent sqlEvent, int place, SqlCategory category) {
        this.user = user;
        this.event = sqlEvent;
        this.place = place;
        this.category = category;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets event entity.
     *
     * @return the event entity
     */
    public SqlEvent getEvent() {
        return event;
    }

    /**
     * Sets event entity.
     *
     * @param sqlEvent the event id
     */
    public void setEvent(SqlEvent sqlEvent) {
        this.event = sqlEvent;
    }

    /**
     * Gets user entity.
     *
     * @return the user entity
     */
    public SqlUser getUser() {
        return user;
    }

    /**
     * Sets user entity.
     *
     * @param user the user entity
     */
    public void setUser(SqlUser user) {
        this.user = user;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public SqlCategory getSqlCategory() {
        return category;
    }

    public void setSqlCategory(SqlCategory category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    /**
     * Sets place.
     *
     * @param place the place
     */
    public void setPlace(int place) {
        this.place = place;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
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
