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
    private MImage mImage;

    @OneToOne
    private MGenre mGenre;

    @OneToOne
    private MBrand mBrand;

    @OneToOne
    private MShop mShop;

    @Column(name = "price")
    private Integer price;

    @Temporal(TemporalType.DATE)
    @Column(name = "buy_date")
    private Date buyDate;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

}
