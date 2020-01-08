package source.controller.images.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.images.ImageController;
import source.usecases.app.images.IImageDeleteUsecase;

@RestController
@RequiredArgsConstructor
public class ImagesDeleteController extends ImageController {
    @Autowired
    private IImageDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.usecase.delete(id);
    }
}
