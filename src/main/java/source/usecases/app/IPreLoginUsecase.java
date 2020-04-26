package source.usecases.app;

import source.domain.entity.firebase.FirebaseVerifiedToken;

public interface IPreLoginUsecase {
    long getUserIdAndSetIfNotExistUser(FirebaseVerifiedToken firebaseVerifiedToken);
}
