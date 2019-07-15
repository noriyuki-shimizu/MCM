package source.usecases.clothes;

import source.domain.dto.input.clothes.ClothesSearchInputData;
import source.domain.entity.Clothes;

import java.util.List;

public interface IClothesSearchUsecase {
    public List<Clothes> search(ClothesSearchInputData inputData);
}
