package source.domain.presenter;

import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.clothes.curd.response.ClothesResponseViewModels;
import source.domain.entity.db.Clothes;

import java.util.List;

public interface IClothesPresenter {
    ClothesAssistResponseViewModels toClothesAssistResponseViewModels(final List<Clothes> clothes);
    ClothesResponseViewModels toClothesResponseViewModels(final List<Clothes> clothes);
    ClothesResponseViewModel toClothesResponseViewModel(final Clothes clothes);
}
