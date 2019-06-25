package source.controller;

import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import source.annotation.NonAuth;
import source.domain.external.firebase.Firebase;
import source.usecases.IPreLoginUsecase;

@RestController
@RequiredArgsConstructor
public class PreLogin {

    @Autowired
    private Firebase firebase;

    @Autowired
    private IPreLoginUsecase usecase;

    @PostMapping("/preLogin")
    @NonAuth
    public long exec(@RequestHeader("Authorization") String token) {
        FirebaseToken decodedToken = firebase.getDecodedToken(token.replace("Bearer ", ""));

        return usecase.getUserIdAndSetIfNotExistUser(decodedToken);
    }
}
