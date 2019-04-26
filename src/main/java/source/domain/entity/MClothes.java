package source.domain.entity;

import lombok.Data;

import javax.persistence.*;
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
    private MGenre mGenre;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private MBrand mBrand;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private MShop mShop;

    @Column(name = "price")
    private Integer price;

    @Temporal(TemporalType.DATE)
    @Column(name = "buy_date")
    private Date buyDate;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

}
