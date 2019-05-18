package source.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "m_shop")
@Data
public class MShop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "link")
    private String link;

    @Column(name = "station_name")
    @NotNull
    private String stationName;

    @OneToOne
    @JoinColumn(name = "image_id")
    @NotNull
    private MImage mImage;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "business_hours")
    @NotNull
    private String businessHours;

    @Column(name = "tel")
    @NotNull
    private String tel;

    @Column(name = "delete_flag")
    @NotNull
    private boolean deleteFlag;

}
