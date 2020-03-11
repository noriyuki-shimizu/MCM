package source.usecases.app.images.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import source.domain.vo.ImageAddresses;
import source.domain.vo.Season;
import source.usecases.app.images.IGetImageAddressUsecase;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class GetImageAddressInteractor implements IGetImageAddressUsecase {
    @Override
    public List<String> handle() {
        final LocalDate now = LocalDate.now();
        Season season = Season.of(now.getMonthValue());

        ImageAddresses imageAddresses = ImageAddresses.of(
                IntStream
                    .range(0, 10)
                    .mapToObj(i -> season.getNowSeasonText() + "/" + (i + 1) + ".jpg")
                    .collect(Collectors.toList())
        );

        return imageAddresses.chooseRamdom().getValues();
    }
}
