package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.db.Genres;

import java.util.Set;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Long>, JpaSpecificationExecutor<Genres> {
    @Query(value = "UPDATE genres SET is_deleted = true, delete_date_time = now() WHERE id = :id", nativeQuery = true)
    Genres deleteById(@Param("id") Long id);

    Set<Genres> findByIdIn(Set<Long> ids);
}
