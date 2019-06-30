package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import source.domain.entity.Clothes;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClothesRepository extends JpaRepository<Clothes, Long>, JpaSpecificationExecutor {
}
