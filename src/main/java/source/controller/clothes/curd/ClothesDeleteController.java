package source.controller.clothes.curd;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.clothes.ClothesController;
import source.usecases.app.clothes.IClothesDeleteUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClothesDeleteController extends ClothesController {
    @Autowired
    private IClothesDeleteUsecase usecase;

    @DeleteMapping(value = "/{id}")
    public String deleteHandler(@PathVariable("id") Long id) {
        try {
            return super.MAPPER.writeValueAsString(this.usecase.delete(id));
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
