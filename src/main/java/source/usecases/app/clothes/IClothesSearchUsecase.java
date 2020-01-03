package source.usecases.app.clothes;

import source.usecases.dto.request.clothes.ClothesSearchRequestData;
import source.domain.entity.Clothes;

import java.util.List;

public interface IClothesSearchUsecase {
    public List<Clothes> search(Long userId, ClothesSearchRequestData inputData);
}
