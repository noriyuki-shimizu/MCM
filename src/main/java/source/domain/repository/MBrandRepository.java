package source.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import source.domain.entity.MBrand;

public interface MBrandRepository extends JpaRepository<MBrand, Integer> {
}
