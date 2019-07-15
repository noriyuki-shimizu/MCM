package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.Genres;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer> {
    @Query(value = "UPDATE genres SET is_deleted = true, delete_date_time = now() WHERE id = :id", nativeQuery = true)
    public Genres deleteById(@Param("id") Long id);
}
