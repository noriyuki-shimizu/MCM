package source.usecases.clothes;

import source.domain.entity.Clothes;

public interface IClothesDeleteUsecase {
    public Clothes delete(Long id);
}
