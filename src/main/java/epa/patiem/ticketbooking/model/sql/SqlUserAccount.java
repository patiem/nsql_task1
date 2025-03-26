package epa.patiem.ticketbooking.model.sql;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "user_accounts")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SqlUserAccount {

    /**
     * The user account id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The user entity.
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private SqlUser user;

    /**
     * The amount of user money.
     */
    @Column(name = "money", nullable = false)
    private BigDecimal money;

    public SqlUserAccount() {
    }

    public SqlUserAccount(SqlUser user, BigDecimal money) {
        this.user = user;
        this.money = money;
    }

    public SqlUserAccount(Long id, SqlUser sqlUser, BigDecimal money) {
        this.id = id;
        this.user = sqlUser;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SqlUser getUser() {
        return user;
    }

    public void setUser(SqlUser sqlUser) {
        this.user = sqlUser;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
