package source.usecases.app.images.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.domain.repository.db.ImagesRepository;
import source.usecases.app.images.IImageSaveUsecase;

import javax.transaction.Transactional;

@Transactional
@Component
public class ImageSaveInteractor implements IImageSaveUsecase {

    @Autowired
    private ImagesRepository repository;

    @Override
    public Images save(Long id, String path) {
        if (id != null) {
            return this.repository.save(
                    Images.builder()
                        .id(id)
                        .path(path)
                        .build()
            );
        }
        if (path != null) {
            return this.repository.save(
                    Images.builder()
                        .path(path)
                        .build()
            );
        }
        return null;
    }
}
