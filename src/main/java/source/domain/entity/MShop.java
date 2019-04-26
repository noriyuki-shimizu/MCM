package source.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "m_shop")
@Data
public class MShop {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_name")
    private String name;

    @Column(name = "link")
    private String link;

    @Column(name = "station_name")
    private String stationName;

    @OneToOne
    @JoinColumn(name = "image_id")
    private MImage mImage;

    @Column(name = "address")
    private String address;

    @Column(name = "business_hours")
    private String businessHours;

    @Column(name = "tel")
    private String tel;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

}
