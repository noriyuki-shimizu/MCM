package source.usecases;

import source.domain.entity.BUser;

public interface IUserFindUsecase {
    public BUser findByUid(final String uid);
}
