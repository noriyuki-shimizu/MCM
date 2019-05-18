package source.domain.entity;

import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "m_brand")
@Data
public class MBrand {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "link")
    private String link;

    @OneToOne
    @JoinColumn(name = "image_id")
    @NotNull
    private MImage mImage;

    @Column(name = "country")
    @NotNull
    private String country;

    @Column(name = "delete_flag")
    @NotNull
    private boolean deleteFlag;

}
