package source.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import source.domain.entity.MClothes;

public interface MClothesRepository extends JpaRepository<MClothes, Long>, JpaSpecificationExecutor {
}
