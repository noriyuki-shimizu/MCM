package source.usecases.brand;

import source.domain.dto.input.brands.BrandSearchInputData;
import source.domain.entity.Brands;

import java.util.List;

public interface IBrandSearchUsecase {
    public List<Brands> search(BrandSearchInputData inputData);
}
