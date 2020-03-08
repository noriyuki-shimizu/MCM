package source.controller.auth;

import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import source.annotation.NonAuth;
import source.infrastructure.firebase.Firebase;
import source.usecases.app.auth.IPreLoginUsecase;

import java.util.Optional;

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
        Optional<FirebaseToken> decodedTokenOpt = this.firebase.getDecodedToken(
                token.replace("Bearer ", "")
        );
        if (!decodedTokenOpt.isPresent()) {
            throw new IllegalArgumentException("Decoding failed !!");
        }

        return this.usecase.getUserIdAndSetIfNotExistUser(decodedTokenOpt.get());
    }
}
