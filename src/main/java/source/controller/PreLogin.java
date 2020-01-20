package source.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.annotation.NonAuth;
import source.infrastructure.firebase.Firebase;
import source.usecases.app.auth.IPreLoginUsecase;

@RestController
@RequiredArgsConstructor
public class PreLogin {

    @Autowired
    private Firebase firebase;

    @Autowired
    private IPreLoginUsecase usecase;

    @PostMapping("/preLogin")
    @NonAuth
    public Long exec(@RequestHeader("Authorization") String token) {
        try {
            FirebaseToken decodedToken = this.firebase.getDecodedToken(token.replace("Bearer ", ""));

            return this.usecase.getUserIdAndSetIfNotExistUser(decodedToken);
        } catch (FirebaseAuthException fae) {
            fae.printStackTrace();
        }
        return null;
    }
}
