package source.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "m_brand")
@Data
public class MBrand {

    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_name")
    private String name;

    @Column(name = "link")
    private String link;

    @OneToOne
    private MImage mImage;

    @Column(name = "country")
    private String country;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

}
