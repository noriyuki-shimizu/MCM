package source.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "m_image")
@Data
public class MImage {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_path")
    private String path;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

}
