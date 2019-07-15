package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.usecases.brands.IBrandDeleteUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DeleteController extends BrandsController {

    @Autowired
    private IBrandDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public String deleteHandler(@PathVariable("id") Long id) {
        try {
            return super.MAPPER.writeValueAsString(this.usecase.delete(id));
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }
}
