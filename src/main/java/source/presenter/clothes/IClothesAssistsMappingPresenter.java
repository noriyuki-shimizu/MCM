package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;

import java.util.List;

public interface IClothesAssistsMappingPresenter {
    public ClothesAssistResponseViewModels mapping(List<Clothes> clothes);
}
