package source.domain.entity;

import lombok.*;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "images")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Images extends TimestampEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "path")
    @NotNull
    private String path;

}
