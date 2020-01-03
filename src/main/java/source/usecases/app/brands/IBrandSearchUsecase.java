package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandSearchRequestData;
import source.domain.entity.Brands;

import java.util.List;

public interface IBrandSearchUsecase {
    public List<Brands> search(Long userId, BrandSearchRequestData inputData);
}
