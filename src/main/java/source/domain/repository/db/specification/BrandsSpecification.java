package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.Brands;

public class BrandsSpecification {
    public static Specification<Brands> userIdEqual(final Long userId) {
        return userId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("userId"), userId);
        };
    }

    public static Specification<Brands> nameLike(final String name) {
        return name == null ? null : (root, query, cb) -> {
            return cb.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Brands> countryEqual(final String country) {
        return country == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("country"), country);
        };
    }

    public static Specification<Brands> isDeletedEqual(final boolean isDeleted) {
        return (root, query, cb) -> {
            return cb.equal(root.get("isDeleted"), isDeleted);
        };
    }
}