package source.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Users extends TimestampEntity {

    @Tolerate
    public Users() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    @NotNull
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "e_mail")
    private String eMail;
}
