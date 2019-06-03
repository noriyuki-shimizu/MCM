package source.domain.dto.user;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import source.domain.entity.BUser;

public class SimpleLoginUser extends User {

    private BUser user;

    public BUser getUser() {
        return user;
    }

    public SimpleLoginUser(BUser user) {
        super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
        this.user = user;
    }

}
