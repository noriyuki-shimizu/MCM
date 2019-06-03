package source.usecases.interactor.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import source.domain.dto.user.SimpleLoginUser;
import source.domain.entity.BUser;
import source.domain.repository.BUserRepository;

@Service("simpleUserDetailsService")
public class SimpleUserDetailsService implements UserDetailsService {

    private final BUserRepository userRepository;

    public SimpleUserDetailsService(BUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) {
        // emailでデータベースからユーザーエンティティを検索する
        BUser bUser = userRepository.findByEMailEquals(email);
        SimpleLoginUser simpleLoginUser = new SimpleLoginUser(bUser);

        if (simpleLoginUser == null) {
            throw new UsernameNotFoundException("user not found.");
        }
        return simpleLoginUser;
    }
}
