package source.usecases.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.BUser;
import source.domain.repository.db.BUserRepository;
import source.usecases.IUserFindUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class UserFindInteractor implements IUserFindUsecase {

    @Autowired
    private BUserRepository repository;

    @Override
    public BUser findByUid(final String uid) {
        return repository.findByUidEquals(uid);
    }
}
