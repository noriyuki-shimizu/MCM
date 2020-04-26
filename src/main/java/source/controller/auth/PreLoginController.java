package source.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import source.annotation.NonAuth;
import source.infrastructure.firebase.Firebase;
import source.infrastructure.firebase.FirebaseVerifiedToken;
import source.usecases.app.auth.IPreLoginUsecase;

@RestController
@RequiredArgsConstructor
public class PreLoginController {

    @Autowired
    private Firebase firebase;

    @Autowired
    private IPreLoginUsecase usecase;

    @PostMapping("/preLogin")
    @NonAuth
    public Long preLogin(@RequestHeader("Authorization") String token) {
        FirebaseVerifiedToken firebaseVerifiedToken = this.firebase
                .getDecodedToken(
                        token.replace("Bearer ", "")
                )
                .orElseThrow(IllegalAccessError::new);

        return this.usecase.getUserIdAndSetIfNotExistUser(firebaseVerifiedToken);
    }
}
