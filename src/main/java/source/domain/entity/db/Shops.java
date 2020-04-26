package source.domain.entity.db;

import lombok.*;
import source.domain.entity.db.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shops")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shops extends TimestampEntity {

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

    @Column(name = "station_name")
    @NotNull
    private String stationName;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Images image;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "business_hours")
    @NotNull
    private String businessHours;

    @Column(name = "tel")
    @NotNull
    private String tel;

}
