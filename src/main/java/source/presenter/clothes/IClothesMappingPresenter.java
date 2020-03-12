package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.controller.clothes.curd.response.ClothesResponseViewModel;

public interface IClothesMappingPresenter {
    ClothesResponseViewModel mapping(Clothes clothes);
}
