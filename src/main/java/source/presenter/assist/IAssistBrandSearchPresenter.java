package source.presenter.assist;

import source.domain.dto.assist.BrandOutputData;
import source.domain.entity.MBrand;

import java.util.List;

public interface IAssistBrandSearchPresenter {
    public List<BrandOutputData> handle(List<MBrand> brandList);
}
