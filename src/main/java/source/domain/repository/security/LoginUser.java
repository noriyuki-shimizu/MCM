package source.domain.repository.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import source.domain.entity.BUser;

public class LoginUser extends User {

    public LoginUser(BUser user) {
        super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
    }
}
