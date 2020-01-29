package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.usecases.dto.response.clothes.ClothesAssistResponseViewModels;

import java.util.List;

public interface IClothesAssistsMappingPresenter {
    public ClothesAssistResponseViewModels mapping(List<Clothes> clothes);
}
