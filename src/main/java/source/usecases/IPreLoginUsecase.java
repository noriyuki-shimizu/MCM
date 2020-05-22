package source.usecases;

import source.domain.entity.firebase.FirebaseVerifiedToken;

public interface IPreLoginUsecase {
    long getUserIdAndSetIfNotExistUser(final FirebaseVerifiedToken firebaseVerifiedToken);
}
