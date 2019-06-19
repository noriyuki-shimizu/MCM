package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import source.domain.entity.BUser;

public interface BUserRepository extends JpaRepository<BUser, Long> {
    BUser findByEMailEquals(final String eMail);
    BUser findByUidEquals(final String uid);
}
