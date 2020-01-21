package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.usecases.dto.response.clothes.ClothesResponseViewModels;

import java.util.List;

public interface IClothesListMappingPresenter {
    public ClothesResponseViewModels mapping(List<Clothes> clothes);
}
