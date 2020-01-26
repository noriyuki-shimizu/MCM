package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.presenter.clothes.IClothesMappingPresenter;
import source.usecases.app.clothes.IClothesDeleteUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

import javax.transaction.Transactional;

@Component
@Transactional
public class ClothesDeleteInteractor implements IClothesDeleteUsecase {

    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IClothesMappingPresenter presenter;

    @Override
    public ClothesResponseViewModel delete(Long id) {
        Clothes clothes = this.repository.deleteById(id);
        return this.presenter.mapping(clothes);
    }
}
