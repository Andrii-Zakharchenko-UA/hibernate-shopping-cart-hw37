package mate.academy.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "shopping_carts_tickets",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private List<Ticket> tickets;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    public ShoppingCart() {
    }

    public ShoppingCart(List<Ticket> tickets, User user) {
        this.tickets = tickets;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "id=" + id
                + ", tickets=" + tickets
                + ", user=" + user
                + '}';
    }
}
