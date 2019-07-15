package source.domain.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import source.domain.entity.Shops;

@Repository
public interface ShopsRepository extends JpaRepository<Shops, Integer> {
    @Query(value = "UPDATE shops SET is_deleted = true, delete_date_time = now() WHERE id = :id", nativeQuery = true)
    public Shops deleteById(@Param("id") Long id);
}