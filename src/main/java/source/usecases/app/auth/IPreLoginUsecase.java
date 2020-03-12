package source.usecases.app.auth;

import com.google.firebase.auth.FirebaseToken;

public interface IPreLoginUsecase {
    long getUserIdAndSetIfNotExistUser(FirebaseToken firebaseToken);
}
