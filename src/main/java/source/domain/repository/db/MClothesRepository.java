package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import source.domain.entity.MClothes;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MClothesRepository extends JpaRepository<MClothes, Long>, JpaSpecificationExecutor {
}
