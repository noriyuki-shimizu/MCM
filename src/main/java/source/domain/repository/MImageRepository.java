package source.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.MImage;

@Repository
public interface MImageRepository extends JpaRepository<MImage, Integer> {
}
