package source.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.db.Users;
import source.domain.repository.db.UsersRepository;
import source.domain.entity.firebase.FirebaseVerifiedToken;
import source.usecases.app.IPreLoginUsecase;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Component
public class PreLoginInteractor implements IPreLoginUsecase {

    @Autowired
    private UsersRepository repository;

    public long getUserIdAndSetIfNotExistUser(final FirebaseVerifiedToken firebaseVerifiedToken) {
        final Optional<Users> users = this.repository.findByUid(firebaseVerifiedToken.getUid());

        if (users.isEmpty()) {
            final Users insertUser = Users.builder()
                    .name(firebaseVerifiedToken.getName())
                    .eMail(firebaseVerifiedToken.getEmail())
                    .uid(firebaseVerifiedToken.getUid())
                    .build();

            return this.repository.save(insertUser).getId();
        }
        return users.get().getId();
    }
}
