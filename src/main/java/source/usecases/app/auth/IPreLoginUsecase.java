package source.usecases.app.auth;

import source.infrastructure.firebase.FirebaseVerifiedToken;

public interface IPreLoginUsecase {
    long getUserIdAndSetIfNotExistUser(FirebaseVerifiedToken firebaseVerifiedToken);
}
