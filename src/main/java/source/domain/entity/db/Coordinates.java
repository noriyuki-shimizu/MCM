package source.domain.entity.db;

import org.codehaus.jackson.annotate.JsonManagedReference;
import lombok.*;
import source.domain.entity.db.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "coordinates")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates extends TimestampEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "season")
    @NotNull
    private String season;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Images image;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "used_coordinates",
            joinColumns = @JoinColumn(name = "coordinate_id"),
            inverseJoinColumns = @JoinColumn(name = "clothing_id")
    )
    private Set<Clothes> usedCoordinates;
}
