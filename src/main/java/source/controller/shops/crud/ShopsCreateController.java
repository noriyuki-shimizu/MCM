package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.usecases.dto.request.shops.ShopCreateRequestData;
import source.usecases.app.shops.IShopCreateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShopsCreateController extends ShopsController {

    @Autowired
    private IShopCreateUsecase usecase;

    @PostMapping(value = "/")
    public String createHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ShopCreateRequestData inputData = super.MAPPER.readValue(inputDataJson, ShopCreateRequestData.class);

            return super.MAPPER.writeValueAsString(this.usecase.create(userId, inputData));
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
