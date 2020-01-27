package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import source.domain.entity.Coordinates;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Long>, JpaSpecificationExecutor {
}
