package source.domain.entity;

import lombok.*;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genres extends TimestampEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "color")
    @NotNull
    private String color;

    @ManyToMany(mappedBy = "genres")
    private Set<Clothes> clothes;

}
