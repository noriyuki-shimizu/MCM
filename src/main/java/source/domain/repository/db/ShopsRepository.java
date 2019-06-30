package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.Shops;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ShopsRepository extends JpaRepository<Shops, Integer> {
}
