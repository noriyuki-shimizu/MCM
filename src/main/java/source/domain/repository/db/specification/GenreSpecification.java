package source.domain.repository.db.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.Genres;

public class GenreSpecification {
    public static Specification<Genres> userIdEqual(final Long userId) {
        return userId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("userId"), userId);
        };
    }
}
