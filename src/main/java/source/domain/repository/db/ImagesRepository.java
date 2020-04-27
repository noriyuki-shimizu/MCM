package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.db.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
    @Query(value = "UPDATE images SET is_deleted = true, delete_date_time = now() WHERE id = :id", nativeQuery = true)
    Images deleteById(@Param("id") final Long id);
}
