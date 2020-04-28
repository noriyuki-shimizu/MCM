package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Genres;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.Collection;
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

    public static Specification<Clothes> hasGenres(final Long genreId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<Clothes> clothes = root;
            Subquery<Genres> genreSubquery = query.subquery(Genres.class);
            Root<Genres> genre = genreSubquery.from(Genres.class);
            Expression<Collection<Clothes>> genreClothes = genre.get("clothes");
            genreSubquery.select(genre);
            genreSubquery.where(cb.equal(genre.get("id"), genreId), cb.isMember(clothes, genreClothes));
            return cb.exists(genreSubquery);
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
            return cb.equal(root.get("isDeleted"), isDeleted);
        };
    }
}
