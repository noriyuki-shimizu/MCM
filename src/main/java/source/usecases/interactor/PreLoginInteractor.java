package source.usecases.clothes.interactor;

import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Users;
import source.domain.repository.db.UsersRepository;
import source.usecases.IPreLoginUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class PreLoginInteractor implements IPreLoginUsecase {

    @Autowired
    private UsersRepository repository;

    public long getUserIdAndSetIfNotExistUser(FirebaseToken firebaseToken) {
        Users users = this.repository.findByUidEquals(firebaseToken.getUid());
        if (users == null) {
            Users insertUser = Users.builder()
                    .name(firebaseToken.getName())
                    .eMail(firebaseToken.getEmail())
                    .uid(firebaseToken.getUid())
                    .build();

            return this.repository.save(insertUser).getId();
        }
        return users.getId();
    }
}
