package source.presenter.clothes;

import source.domain.entity.Clothes;
import source.controller.clothes.curd.response.ClothesResponseViewModel;

public interface IClothesMappingPresenter {
    public ClothesResponseViewModel mapping(Clothes clothes);
}
