package source.usecases.app.assist;

import source.usecases.dto.response.assist.BrandResponseData;

import java.util.List;

public interface IAssistBrandSearchUsecase {
    public List<BrandResponseData> getAssistBrandList();
}
