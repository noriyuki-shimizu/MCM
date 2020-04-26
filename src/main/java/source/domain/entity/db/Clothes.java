package source.domain.entity.db;

import lombok.*;
import source.domain.entity.db.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "clothes")
@Getter
@Setter
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
    @JoinColumn(name = "image_id")
    private Images image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "clothing_genres",
            joinColumns = @JoinColumn(name = "clothing_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genres> genres;

    @OneToOne
    @JoinColumn(name = "brand_id")
    @NotNull
    private Brands brand;

    @OneToOne
    @JoinColumn(name = "shop_id")
    @NotNull
    private Shops shop;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @Column(name = "buy_date")
    @NotNull
    private Date buyDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "satisfaction")
    private BigDecimal satisfaction;

    @ManyToMany(mappedBy = "usedCoordinates")
    private Set<Coordinates> coordinates;

}
