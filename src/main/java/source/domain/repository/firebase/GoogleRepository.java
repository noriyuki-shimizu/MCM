package source.domain.repository.firebase;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

/**
 * Firebaseに対するリポジトリクラスです.
 */
public interface FirebaseRepository {

    /**
     * GoogleからJWKSを取得します。
     *
     * @return JWKS
     */
    @GET("/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
    Call<Map<String, Object>> getJwks();
}
