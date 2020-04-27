package source.domain.presenter.clothes;

import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.domain.entity.db.Clothes;

public interface IClothesMappingPresenter {
    ClothesResponseViewModel mapping(final Clothes clothes);
}
