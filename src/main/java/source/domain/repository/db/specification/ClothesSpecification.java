package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.Brands;
import source.domain.entity.Clothes;

import javax.persistence.criteria.JoinType;
import java.util.Date;

public class ClothesSpecification {

    public static Specification<Clothes> userIdEqual(final Long userId) {
        return userId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("userId"), userId);
        };
    }

    public static Specification<Clothes> brandIdContains(final Long brandId) {
        return brandId == null ? null : (root, query, cb) -> {
            return cb.equal(root.join("brand", JoinType.INNER).get("id"), brandId);
        };
    }

    public static Specification<Clothes> genreIdEqual(final Long genreId) {
        return genreId == null ? null : (root, query, cb) -> {
            return cb.equal(root.join("genre", JoinType.INNER).get("id"), genreId);
        };
    }

    public static Specification<Clothes> shopIdEqual(final Long shopId) {
        return shopId == null ? null : (root, query, cb) -> {
            return cb.equal(root.join("shop", JoinType.INNER).get("id"), shopId);
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

    public static Specification<Clothes> isDeleted(final boolean isDeleted) {
        return (root, query, cb) -> {
            return cb.equal(root.get("is_deleted"), isDeleted);
        };
    }
}
