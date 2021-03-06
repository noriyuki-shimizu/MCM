package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.db.Shops;

public class ShopsSpecification {
    public static Specification<Shops> userIdEqual(final Long userId) {
        return userId == null ? null : (root, query, cb) -> cb.equal(root.get("userId"), userId);
    }

    public static Specification<Shops> nameLike(final String name) {
        return name == null ? null : (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Shops> stationNameLike(final String stationName) {
        return stationName == null ? null : (root, query, cb) -> cb.like(root.get("stationName"), "%" + stationName + "%");
    }

    public static Specification<Shops> addressLike(final String address) {
        return address == null ? null : (root, query, cb) -> cb.like(root.get("address"), "%" + address + "%");
    }

    public static Specification<Shops> isDeleted(final boolean isDeleted) {
        return (root, query, cb) -> cb.equal(root.get("isDeleted"), isDeleted);
    }
}
