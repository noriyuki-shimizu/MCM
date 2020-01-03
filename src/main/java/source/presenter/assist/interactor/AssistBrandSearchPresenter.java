package source.presenter.assist.interactor;

import org.springframework.stereotype.Component;
import source.usecases.dto.response.assist.BrandResponseData;
import source.domain.entity.Brands;
import source.presenter.assist.IAssistBrandSearchPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistBrandSearchPresenter implements IAssistBrandSearchPresenter {

    @Override
    public List<BrandResponseData> handle(List<Brands> brandList) {
        return brandList.stream().map(brand -> BrandResponseData.of(brand.getId(), brand.getName()))
                                 .collect(Collectors.toList());
    }
}
