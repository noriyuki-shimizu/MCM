package source.infrastructure.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.firebase.FirebaseVerifiedToken;
import source.util.FirebaseEnv;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Optional;

@Component
public class Firebase {

    @Autowired
    private FirebaseEnv env;

    private FirebaseApp app;

    /**
     * Firebase API の初期処理を行います.
     */
    @PostConstruct
    private void initializeApp() {
        try {
            final FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(env.getServiceAccount()))
                    .setDatabaseUrl(env.getDatabaseUrl())
                    .build();

            app = FirebaseApp.initializeApp(options, env.getApiName());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * インスタンスを削除します.
     */
    @PreDestroy
    private void deleteApp() {
        app.delete();
    }

    /**
     * 引数のトークン情報から、UIDを取得します.
     *
     * @return Optional<FirebaseToken>
     */
    public Optional<FirebaseVerifiedToken> getDecodedToken(final String token) {
        // idToken comes from the client app (shown above)
        try {
            final FirebaseToken firebaseToken = FirebaseAuth.getInstance(app).verifyIdToken(token);
            return Optional.of(
                    FirebaseVerifiedToken.of(
                            firebaseToken.getUid(),
                            firebaseToken.getName(),
                            firebaseToken.getEmail()
                    )
            );
        } catch (FirebaseAuthException e) {
            return Optional.empty();
        }
    }

}
