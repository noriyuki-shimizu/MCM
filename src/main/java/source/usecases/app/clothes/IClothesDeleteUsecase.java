package source.usecases.app.clothes;

import source.domain.entity.Clothes;

public interface IClothesDeleteUsecase {
    public Clothes delete(Long id);
}
