package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long>, JpaSpecificationExecutor {
    @Query(value = "UPDATE brands SET is_deleted = true, delete_date_time = now() WHERE id = :id", nativeQuery = true)
    public Brands deleteById(@Param("id") Long id);
}