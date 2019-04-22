package source.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.domain.entity.MGenre;

@Repository
public interface MGenreRepository extends JpaRepository<MGenre, Integer> {
}
