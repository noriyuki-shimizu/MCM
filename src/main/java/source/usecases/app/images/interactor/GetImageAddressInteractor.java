package source.usecases.app.images.interactor;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.vo.ImageAddresses;
import source.infrastructure.scraping.images.IScrapingImage;
import source.usecases.app.images.IGetImageAddressUsecase;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetImageAddressInteractor implements IGetImageAddressUsecase {
    @Autowired
    private IScrapingImage scrapingImage;

    @Override
    public ImageAddresses handle() {
        Elements elements = this.scrapingImage.getImageAddresses();

        List imageAddresses = new ArrayList<>();
        for (Element element : elements) {
            imageAddresses.add(element.attr("href"));
        }

        return ImageAddresses.of(imageAddresses).chooseRamdom();
    }
}
