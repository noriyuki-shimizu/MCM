package source.domain.presenter.clothes;

import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;
import source.domain.entity.db.Clothes;

import java.util.List;

public interface IClothesAssistsMappingPresenter {
    ClothesAssistResponseViewModels mapping(List<Clothes> clothes);
}
