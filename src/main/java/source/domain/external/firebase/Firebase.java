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

import java.io.IOException;

@Component
public class Firebase {

    @Autowired
    private FirebaseEnv env;

    private FirebaseApp firebaseApp;

    /**
     * Firebase API の初期処理を行います.
     */
    public void initializeApp() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(this.env.getServiceAccount()))
                    .setDatabaseUrl(this.env.getDatabaseUrl())
                    .build();

            this.firebaseApp = FirebaseApp.initializeApp(options, this.env.getApiName());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * インスタンスを削除します.
     */
    public void deleteApp() {
        this.firebaseApp.delete();
    }

    /**
     * 引数のトークン情報から、UIDを取得します.
     *
     * @return
     */
    public FirebaseToken getDecodedToken(String token) {
        try {
            // idToken comes from the client app (shown above)
            return FirebaseAuth.getInstance(this.firebaseApp).verifyIdToken(token);
        } catch (FirebaseAuthException fae) {
            fae.printStackTrace();
        }
        return null;
    }

}
