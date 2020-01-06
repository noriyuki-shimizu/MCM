package source.usecases.app.brands;

import source.usecases.dto.response.brands.BrandResponseModel;

import java.util.List;

public interface IBrandSearchUsecase {
    public List<BrandResponseModel> search(Long userId);
}
