package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.Clothes;

import javax.persistence.criteria.JoinType;
import java.util.Date;

public class ClothesSpecification {

    public static Specification<Clothes> brandIdContains(final Integer brandId) {
        return brandId == null ? null : (root, query, cb) -> {
            return cb.equal(root.join("brand", JoinType.LEFT).get("id"), brandId);
        };
    }

    public static Specification<Clothes> genreIdEqual(final Integer genreId) {
        return genreId == null ? null : (root, query, cb) -> {
            return cb.equal(root.join("genre", JoinType.LEFT).get("id"), genreId);
        };
    }

    public static Specification<Clothes> shopIdEqual(final Integer shopId) {
        return shopId == null ? null : (root, query, cb) -> {
            return cb.equal(root.join("shop", JoinType.LEFT).get("id"), shopId);
        };
    }

    public static Specification<Clothes> priceLessEqual(final Integer price) {
        return price == null ? null : (root, query, cb) -> {
            return cb.lessThanOrEqualTo(root.get("price"), price);
        };
    }

    public static Specification<Clothes> priceGreaterEqual(final Integer price) {
        return price == null ? null : (root, query, cb) -> {
            return cb.greaterThanOrEqualTo(root.get("price"), price);
        };
    }

    public static Specification<Clothes> buyDateEqual(final Date buyDate) {
        return buyDate == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("buyDate"), buyDate);
        };
    }

    public static Specification<Clothes> deleteFlagEqual(final boolean isDeleted) {
        return (root, query, cb) -> {
            return cb.equal(root.get("is_deleted"), isDeleted);
        };
    }
}
