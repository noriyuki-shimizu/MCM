package source.usecases.app.auth;

import com.google.firebase.auth.FirebaseToken;

public interface IPreLoginUsecase {
    public long getUserIdAndSetIfNotExistUser(FirebaseToken firebaseToken);
}
