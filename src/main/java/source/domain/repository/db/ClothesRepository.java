package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.Clothes;

import java.util.Set;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>, JpaSpecificationExecutor {
    @Query(value = "SELECT sum(price) FROM clothes WHERE user_id = :user_id", nativeQuery = true)
    public int sumPrice(@Param("user_id") Long userId);

    @Query(value = "UPDATE clothes SET is_deleted = true, delete_date_time = now() WHERE id = :id RETURNING *", nativeQuery = true)
    public Clothes deleteById(@Param("id") Long id);

    // Restoration
    @Query(value = "UPDATE clothes SET is_deleted = false, update_date_time = now(), delete_date_time = null WHERE id = :id RETURNING *", nativeQuery = true)
    public Clothes restorationById(@Param("id") Long id);

    public Set<Clothes> findByIdIn(Set<Long> ids);
}
