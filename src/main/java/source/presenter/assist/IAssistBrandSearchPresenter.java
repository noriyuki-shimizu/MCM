package source.presenter.assist;

import source.usecases.dto.response.assist.BrandResponseData;
import source.domain.entity.Brands;

import java.util.List;

public interface IAssistBrandSearchPresenter {
    public List<BrandResponseData> handle(List<Brands> brandList);
}
