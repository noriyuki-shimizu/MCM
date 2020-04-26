package source.interactor;

import com.google.firebase.auth.FirebaseAuthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import source.domain.entity.Users;
import source.domain.repository.db.UsersRepository;
import source.infrastructure.firebase.FirebaseVerifiedToken;
import source.usecases.app.auth.interactor.PreLoginInteractor;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

@SpringBootTest
class PreLoginControllerInteractorTest {
    @Mock
    private UsersRepository repository;

    @InjectMocks
    private PreLoginInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserIdAndSetIfNotExistUser() {
        Users users = Users.builder().id(1L).uid("fjoaYU9LHsr34d5fkks45djf").eMail("test@test.com").name("test user").build();
        when(repository.findByUid(anyObject())).thenReturn(Optional.of(users));

        long userId = interactor.getUserIdAndSetIfNotExistUser(FirebaseVerifiedToken.of(users.getUid(), users.getName(), users.getEMail()));
        assertThat(1L, is(userId));

        when(repository.findByUid(anyObject())).thenReturn(Optional.empty());
        Users newUsers = Users.builder().id(2L).uid("ef9_Ihod23oi").eMail("new@new.com").name("new user").build();
        when(repository.save(newUsers)).thenReturn(newUsers);

        long newUserId = interactor.getUserIdAndSetIfNotExistUser(FirebaseVerifiedToken.of(users.getUid(), users.getName(), users.getEMail()));
        assertThat(2L, is(newUserId));
    }
}