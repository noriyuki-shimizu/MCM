package source.usecases;

import source.domain.dto.clothes.ClothesSearchInputData;
import source.domain.dto.clothes.ClothesSearchOutputData;

import java.util.List;

public interface IClothesSearchUsecase {
    public List<ClothesSearchOutputData> search(ClothesSearchInputData inputData);
}
