package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import source.domain.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEMailEquals(final String eMail);
    Users findByUidEquals(final String uid);
}
