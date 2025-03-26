package epa.patiem.ticketbooking.model.sql;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static epa.patiem.ticketbooking.utils.Constants.DATE_FORMATTER;

@Entity
@Table(name = "events")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SqlEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "ticket_price", nullable = false)
    private BigDecimal ticketPrice;


    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<SqlTicket> tickets = new ArrayList<>();

    public SqlEvent() {
    }

    public SqlEvent(String title, Date date, BigDecimal ticketPrice) {
        this.title = title;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    public SqlEvent(Long id, String title, Date date, BigDecimal ticketPrice) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void addTicket(SqlTicket sqlTicket) {
        this.tickets.add(sqlTicket);
        sqlTicket.setEvent(this);
    }

    public List<SqlTicket> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SqlEvent event = (SqlEvent) o;
        return Objects.equals(id, event.id) && Objects.equals(title, event.title) && Objects.equals(date, event.date) && Objects.equals(ticketPrice, event.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, ticketPrice);
    }

    @Override
    public String toString() {
        return "{" +
                "'id' : " + id +
                ", 'title' : '" + title + '\'' +
                ", 'date' : '" + DATE_FORMATTER.format(date) +
                "', 'ticket_price' : " + ticketPrice +
                "}";
    }
}
