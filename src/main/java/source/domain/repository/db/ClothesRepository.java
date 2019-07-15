package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.Brands;
import source.domain.entity.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>, JpaSpecificationExecutor {
    @Query("UPDATE clothes SET is_deleted = true, delete_date_time = now() WHERE id = :id")
    public Brands deleteById(@Param("id") Long id);
}
