package source.controller.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import source.annotation.NonAuth;
import source.domain.entity.firebase.FirebaseVerifiedToken;
import source.infrastructure.firebase.Firebase;
import source.usecases.app.IPreLoginUsecase;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PreLoginController {

    @Autowired
    private Firebase firebase;

    @Autowired
    private IPreLoginUsecase usecase;

    @PostMapping("/preLogin")
    @NonAuth
    public Long preLogin(@RequestHeader("Authorization") String token, @RequestBody String userAgent) {
        FirebaseVerifiedToken firebaseVerifiedToken = firebase
                .getDecodedToken(
                        token.replace("Bearer ", "")
                )
                .orElseThrow(IllegalAccessError::new);

        long loginUserId = usecase.getUserIdAndSetIfNotExistUser(firebaseVerifiedToken);

        log.info(String.format("userId: %4d, userAgent: %s", loginUserId, userAgent));

        return loginUserId;
    }
}
