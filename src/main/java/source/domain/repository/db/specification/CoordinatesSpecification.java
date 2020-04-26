package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Coordinates;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.Collection;

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

    public static Specification<Coordinates> hasClothes(final Long clothingId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<Coordinates> coordinate = root;
            Subquery<Clothes> clothesSubquery = query.subquery(Clothes.class);
            Root<Clothes> clothes = clothesSubquery.from(Clothes.class);
            Expression<Collection<Coordinates>> clothesCoordinate = clothes.get("coordinates");
            clothesSubquery.select(clothes);
            clothesSubquery.where(cb.equal(clothes.get("id"), clothingId), cb.isMember(coordinate, clothesCoordinate));
            return cb.exists(clothesSubquery);
        };
    }
}
