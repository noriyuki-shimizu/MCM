package source.usecases.app.brands;

import source.domain.entity.Brands;

public interface IBrandDeleteUsecase {
    public Brands delete(Long id);
}
