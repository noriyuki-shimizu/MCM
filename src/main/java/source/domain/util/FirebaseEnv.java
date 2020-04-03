package source.domain.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "settings.firebase")
@Data
public class FirebaseEnv {

    private String webUrls;

    private String apiName;

    private String serviceAccount;

    private String databaseUrl;

    @Autowired
    private ResourceLoader resourceLoader;

    public InputStream getServiceAccount() {
        try {
            URL url = resourceLoader.getResource(this.serviceAccount).getURL();
            return url.openStream();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public List<String> getWebUrls() {
        return Arrays.asList(this.webUrls.split("[,]"));
    }

}
