package source.infrastructure.firebase;

import lombok.Value;

@Value(staticConstructor = "of")
public class FirebaseVerifiedToken {
    private String uid;
    private String name;
    private String email;
}
