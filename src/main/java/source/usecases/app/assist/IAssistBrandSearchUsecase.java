package source.usecases.app.assist;

import source.usecases.dto.output.assist.BrandOutputData;

import java.util.List;

public interface IAssistBrandSearchUsecase {
    public List<BrandOutputData> getAssistBrandList();
}
