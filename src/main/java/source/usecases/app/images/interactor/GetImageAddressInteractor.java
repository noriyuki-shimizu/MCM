package source.usecases.app.images.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.vo.ImageAddresses;
import source.infrastructure.scraping.images.IScrapingImage;
import source.usecases.app.images.IGetImageAddressUsecase;

import java.util.List;

@Component
public class GetImageAddressInteractor implements IGetImageAddressUsecase {
    @Autowired
    private IScrapingImage scrapingImage;

    @Override
    public ImageAddresses handle() {
        List<String> imageAddresses = this.scrapingImage.pickImageAddresses();

        return ImageAddresses.of(imageAddresses).chooseRamdom();
    }
}
