package source.usecases.app.brands;

import source.usecases.dto.input.brands.BrandSearchInputData;
import source.domain.entity.Brands;

import java.util.List;

public interface IBrandSearchUsecase {
    public List<Brands> search(Long userId, BrandSearchInputData inputData);
}
