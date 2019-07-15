package source.usecases.images.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.domain.repository.db.ImagesRepository;
import source.usecases.images.IImageCreateUsecase;

@Component
public class ImageCreateInteractor implements IImageCreateUsecase {

    @Autowired
    private ImagesRepository repository;

    @Override
    public Images create(Images images) {
        return this.repository.save(images);
    }
}
