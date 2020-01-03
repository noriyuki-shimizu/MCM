package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.dto.request.shops.ShopUpdateRequestData;
import source.usecases.app.shops.IShopUpdateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShopUpdateController extends ShopsController {

    @Autowired
    private IShopUpdateUsecase usecase;

    @PutMapping(value = "/")
    public String updateHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ShopUpdateRequestData inputData = super.MAPPER.readValue(inputDataJson, ShopUpdateRequestData.class);

            return super.MAPPER.writeValueAsString(this.usecase.update(userId, inputData));
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
