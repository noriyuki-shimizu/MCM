package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>, JpaSpecificationExecutor {
    @Query(value = "SELECT sum(price) FROM clothes WHERE user_id = :user_id", nativeQuery = true)
    public int sumPrice(@Param("user_id") Long userId);

    @Query(value = "UPDATE clothes SET is_deleted = true, delete_date_time = now() WHERE id = :id", nativeQuery = true)
    public Clothes deleteById(@Param("id") Long id);
}
