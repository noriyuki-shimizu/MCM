package source.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@Builder
public class Users extends TimestampEntity {

    @Tolerate
    public Users() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0l;

    @Column(name = "uid")
    @NotNull
    private String uid = "";

    @Column(name = "name")
    private String name = "";

    @Column(name = "e_mail")
    @NotNull
    private String eMail = "";
}
