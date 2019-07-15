package source.usecases.brands;

import source.domain.entity.Brands;

public interface IBrandDeleteUsecase {
    public Brands delete(Long id);
}
