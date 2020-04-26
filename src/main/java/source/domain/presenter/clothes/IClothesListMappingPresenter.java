package source.domain.presenter.clothes;

import source.controller.clothes.curd.response.ClothesResponseViewModels;
import source.domain.entity.db.Clothes;

import java.util.List;

public interface IClothesListMappingPresenter {
    ClothesResponseViewModels mapping(List<Clothes> clothes);
}
