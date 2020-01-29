package source.usecases.app.images.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Images;
import source.domain.repository.db.ImagesRepository;
import source.usecases.app.images.IImageSaveUsecase;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Component
public class ImageSaveInteractor implements IImageSaveUsecase {

    @Autowired
    private ImagesRepository repository;

    @Override
    public Images save(Long id, String path) {
        if (Optional.ofNullable(id).isPresent()) {
            return this.repository.save(
                    Images.builder()
                        .id(id)
                        .path(path)
                        .build()
            );
        }
        if (Optional.ofNullable(path).isPresent()) {
            return this.repository.save(
                    Images.builder()
                        .path(path)
                        .build()
            );
        }
        return null;
    }
}
