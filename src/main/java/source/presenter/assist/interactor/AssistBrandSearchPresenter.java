package source.presenter.assist.interactor;

import org.springframework.stereotype.Component;
import source.domain.dto.output.assist.BrandOutputData;
import source.domain.entity.Brands;
import source.presenter.assist.IAssistBrandSearchPresenter;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistBrandSearchPresenter implements IAssistBrandSearchPresenter {

    @Override
    public List<BrandOutputData> handle(List<Brands> brandList) {
        return brandList.stream().map(brand -> BrandOutputData.of(brand.getId(), brand.getName()))
                                 .collect(Collectors.toList());
    }
}
