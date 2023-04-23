package crud;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanet;
    public Ticket() {
    }
    public Ticket(LocalDateTime createdAt, Client client, Planet fromPlanet, Planet toPlanet) {
        this.createdAt = createdAt;
        this.client = client;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Planet getFromPlanet() {
        return fromPlanet;
    }
    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }
    public Planet getToPlanet() {
        return toPlanet;
    }
    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("id=").append(id);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", client=").append(client);
        sb.append(", fromPlanet=").append(fromPlanet);
        sb.append(", toPlanet=").append(toPlanet);
        sb.append("}\n");
        return sb.toString();
    }
}