package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.db.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEMailEquals(final String eMail);
    Optional<Users> findByUid(final String uid);
    Optional<Users> findByIdAndUid(final Long id, final String uid);
}
