package source.domain.entity;

import lombok.Data;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "b_user")
@Data
public class BUser extends TimestampEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "e_mail")
    @NotNull
    private String eMail;

    @Column(name = "password")
    @NotNull
    private String password;
}
