package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.Clothes;
import source.domain.entity.Coordinates;

import javax.persistence.criteria.Root;

public class CoordinatesSpecification {
    public static Specification<Coordinates> userIdEqual(final Long userId) {
        return userId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("userId"), userId);
        };
    }

    public static Specification<Coordinates> seasonEqual(final String season) {
        return season == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("season"), season);
        };
    }

    public static Specification<Coordinates> isDeleted(final boolean isDeleted) {
        return (root, query, cb) -> {
            return cb.equal(root.get("isDeleted"), isDeleted);
        };
    }

    public static Specification<Coordinates> hasOwnerName(final Long clothingId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<Coordinates> coordinate = root;
            Root<Clothes> clothes = query.from(Clothes.class);
            return cb.and(cb.equal(clothes.get("id"), clothingId));
        };
    }
}
