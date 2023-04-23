package crud;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Planet {
    @Id
    private String id;
    @Column(length = 500, nullable = false)
    private String name;
    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL)
    private Set<Ticket> fromPlanetTickets = new HashSet<>();
    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL)
    private Set<Ticket> toPlanetTickets = new HashSet<>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planet{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}').append('\'');
        return sb.toString();
    }
}
