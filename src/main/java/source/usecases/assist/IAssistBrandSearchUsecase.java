package source.usecases.assist;

import source.domain.dto.assist.BrandOutputData;

import java.util.List;

public interface IAssistBrandSearchUsecase {

    public List<BrandOutputData> getAssistBrandList();

}
