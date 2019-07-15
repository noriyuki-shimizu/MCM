package source.domain.external.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.util.FirebaseEnv;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

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
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(this.env.getServiceAccount()))
                    .setDatabaseUrl(this.env.getDatabaseUrl())
                    .build();

            this.app = FirebaseApp.initializeApp(options, this.env.getApiName());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * インスタンスを削除します.
     */
    @PreDestroy
    private void deleteApp() {
        this.app.delete();
    }

    /**
     * 引数のトークン情報から、UIDを取得します.
     *
     * @return
     */
    public FirebaseToken getDecodedToken(String token) throws FirebaseAuthException {
        // idToken comes from the client app (shown above)
        return FirebaseAuth.getInstance(this.app).verifyIdToken(token);
    }

}
