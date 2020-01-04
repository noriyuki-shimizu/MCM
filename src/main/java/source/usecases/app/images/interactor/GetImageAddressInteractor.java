package source.usecases.app.images.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.vo.ImageAddresses;
import source.infrastructure.scraping.images.IScrapingImage;
import source.usecases.app.images.IGetImageAddressUsecase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
@Slf4j
public class GetImageAddressInteractor implements IGetImageAddressUsecase {
    @Autowired
    private IScrapingImage scrapingImage;

    @Override
    public List<String> handle() {
        try {
            ImageAddresses imageAddresses = ImageAddresses.of(
                    this.scrapingImage.pickImageAddresses()
            );

            return imageAddresses
                    .chooseRamdom()
                    .getValues();
        } catch (UnsupportedEncodingException uee) {
            log.error("URL のデコードに失敗しました。", uee);
            return null;
        } catch (IOException ioe) {
            log.error("指定した URL にアクセスできませんでした。確認してください。", ioe);
            return null;
        }
    }
}
