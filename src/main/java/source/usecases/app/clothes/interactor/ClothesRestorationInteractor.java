package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.presenter.clothes.IClothesMappingPresenter;
import source.usecases.app.clothes.IClothesRestorationUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class ClothesRestorationInteractor implements IClothesRestorationUsecase {
    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IClothesMappingPresenter presenter;

    @Override
    public ClothesResponseViewModel restoration(Long id) {
        Clothes clothes = this.repository.restorationById(id);
        return this.presenter.mapping(clothes);
    }
}
