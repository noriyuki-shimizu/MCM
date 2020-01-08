package source.usecases.app.images.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.repository.db.ImagesRepository;
import source.usecases.app.images.IImageDeleteUsecase;

import javax.transaction.Transactional;

@Transactional
@Component
public class ImageDeleteInteractor implements IImageDeleteUsecase {
    @Autowired
    private ImagesRepository repository;

    @Override
    public void delete(Integer id) {
        this.repository.delete(id);
    }
}
