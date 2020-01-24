package source.usecases.app.auth.interactor;

import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Users;
import source.domain.repository.db.UsersRepository;
import source.usecases.app.auth.IPreLoginUsecase;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Component
public class PreLoginInteractor implements IPreLoginUsecase {

    @Autowired
    private UsersRepository repository;

    public long getUserIdAndSetIfNotExistUser(FirebaseToken firebaseToken) {
        Optional<Users> users = Optional.ofNullable(
                this.repository.findByUid(firebaseToken.getUid())
        );

        if (!users.isPresent()) {
            Users insertUser = Users.builder()
                    .name(firebaseToken.getName())
                    .eMail(firebaseToken.getEmail())
                    .uid(firebaseToken.getUid())
                    .build();

            return this.repository.save(insertUser).getId();
        }
        return users.get().getId();
    }
}
