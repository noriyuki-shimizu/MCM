package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.controller.clothes.curd.response.ClothesResponseViewModels;

import java.util.List;

public interface IClothesListMappingPresenter {
    ClothesResponseViewModels mapping(List<Clothes> clothes);
}
