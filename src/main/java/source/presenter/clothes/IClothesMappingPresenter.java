package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

public interface IClothesMappingPresenter {
    public ClothesResponseViewModel mapping(Clothes clothes);
}
