package source.domain.entity;

import lombok.Builder;
import lombok.Data;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "brands")
@Data
@Builder
public class Brands extends TimestampEntity {

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

    @Column(name = "link")
    private String link;

    @OneToOne
    @JoinColumn(name = "image_id")
    @NotNull
    private Images image;

    @Column(name = "country")
    @NotNull
    private String country;

}
