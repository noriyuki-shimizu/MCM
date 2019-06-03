package source.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import source.domain.env.AuthEnv;

@RunWith(SpringRunner.class)
public class EnvTest {
    @Autowired
    private AuthEnv auth;

    @Test
    public void confirm() {
        System.out.println(auth.getSecret());
    }
}
