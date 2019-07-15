package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEMailEquals(final String eMail);
    Users findByUidEquals(final String uid);
}
