package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.db.Brands;

import java.util.List;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long>, JpaSpecificationExecutor<Brands> {
    List<Brands> findByIsDeletedOrderByUserId(final boolean isDeleted);

    List<Brands> findByUserIdOrderByName(final Long userId);

    List<Brands> findByUserIdAndIsDeletedOrderByName(final Long userId, final boolean isDeleted);

    @Query(value = "UPDATE brands SET is_deleted = true, delete_date_time = now() WHERE id = :id RETURNING *", nativeQuery = true)
    Brands deleteById(@Param("id") final Long id);

    // Restoration
    @Query(value = "UPDATE brands SET is_deleted = false, update_date_time = now(), delete_date_time = null WHERE id = :id RETURNING *", nativeQuery = true)
    Brands restorationById(@Param("id") final Long id);
}
