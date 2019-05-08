package source.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "m_clothes")
@Data
public class MClothes {

    @Id
    @Column(name = "clothes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "image_id")
    private MImage mImage;

    @OneToOne
    @JoinColumn(name = "genre_id")
    @NotNull
    private MGenre mGenre;

    @OneToOne
    @JoinColumn(name = "brand_id")
    @NotNull
    private MBrand mBrand;

    @OneToOne
    @JoinColumn(name = "shop_id")
    @NotNull
    private MShop mShop;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @Temporal(TemporalType.DATE)
    @Column(name = "buy_date")
    @NotNull
    private Date buyDate;

    @Column(name = "delete_flag")
    @NotNull
    private boolean deleteFlag;

}
