package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.MImage;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MImageRepository extends JpaRepository<MImage, Integer> {
}
