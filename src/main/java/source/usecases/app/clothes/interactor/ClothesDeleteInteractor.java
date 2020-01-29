package source.usecases.app.clothes.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.entity.Coordinates;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.CoordinatesRepository;
import source.domain.repository.db.specification.CoordinatesSpecification;
import source.presenter.clothes.IClothesMappingPresenter;
import source.usecases.app.clothes.IClothesDeleteUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
@Slf4j
public class ClothesDeleteInteractor implements IClothesDeleteUsecase {

    @Autowired
    private ClothesRepository repository;

    @Autowired
    private CoordinatesRepository coordinatesRepository;

    @Autowired
    private IClothesMappingPresenter presenter;

    @Override
    public ClothesResponseViewModel delete(Long id) {
        List<Coordinates> coordinates = this.coordinatesRepository.findAll(
                Specifications
                        .where(CoordinatesSpecification.hasOwnerName(id))
        );
        if(coordinates.size() > 0) {
            String errorMessage = "The clothes cannot be deleted because it is used by other data.";
            log.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        Clothes clothes = this.repository.deleteById(id);
        return this.presenter.mapping(clothes);
    }
}
