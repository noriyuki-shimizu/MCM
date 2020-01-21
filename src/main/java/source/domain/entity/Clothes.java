package source.domain.entity;

import lombok.*;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clothes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clothes extends TimestampEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "image_id")
    private Images image;

    @ManyToMany
    @JoinTable(
            name = "clothing_genres",
            joinColumns = @JoinColumn(name = "clothing_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genres> genres;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "brand_id")
    @NotNull
    private Brands brand;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "shop_id")
    @NotNull
    private Shops shop;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @Temporal(TemporalType.DATE)
    @Column(name = "buy_date")
    @NotNull
    private Date buyDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "satisfaction")
    private Float satisfaction;
}
