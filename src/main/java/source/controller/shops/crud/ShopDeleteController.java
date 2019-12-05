package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopDeleteUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShopDeleteController extends ShopsController {

    @Autowired
    private IShopDeleteUsecase usecase;

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
