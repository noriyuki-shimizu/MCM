package source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.external.firebase.Firebase;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * アプリケーションのBeanライフサイクルを管理する
 */
@Component
public class BeanLifeCycle {

    @Autowired
    private Firebase firebase;

    /**
     * サーバ起動時の初期処理を行います.
     */
    @PostConstruct
    public void initAfterStartup() {
        this.firebase.initializeApp();
    }

    /**
     * サーバ停止時の処理を行います.
     */
    @PreDestroy
    public void cleanupBeforeExit() {
        this.firebase.deleteApp();
    }

}
