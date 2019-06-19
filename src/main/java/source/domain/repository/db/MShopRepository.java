package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.MShop;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MShopRepository extends JpaRepository<MShop, Integer> {
}
