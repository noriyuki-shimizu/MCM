package source.presenter.assist;

import source.usecases.dto.output.assist.BrandOutputData;
import source.domain.entity.Brands;

import java.util.List;

public interface IAssistBrandSearchPresenter {
    public List<BrandOutputData> handle(List<Brands> brandList);
}
