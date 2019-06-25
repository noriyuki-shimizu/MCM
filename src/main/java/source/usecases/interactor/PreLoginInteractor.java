package source.usecases.interactor;

import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.BUser;
import source.domain.repository.db.BUserRepository;
import source.usecases.IPreLoginUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class PreLoginInteractor implements IPreLoginUsecase {

    @Autowired
    private BUserRepository repository;

    public long getUserIdAndSetIfNotExistUser(FirebaseToken firebaseToken) {
        BUser bUser = this.repository.findByUidEquals(firebaseToken.getUid());
        if (bUser == null) {
            BUser insertUser = BUser.builder()
                    .name(firebaseToken.getName())
                    .eMail(firebaseToken.getEmail())
                    .uid(firebaseToken.getUid())
                    .build();

            return this.repository.save(insertUser).getId();
        }
        return bUser.getId();
    }
}
