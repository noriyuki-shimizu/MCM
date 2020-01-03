package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.domain.entity.Brands;
import source.usecases.dto.request.brands.BrandUpdateRequestData;
import source.usecases.app.brands.IBrandUpdateUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BrandsUpdateController extends BrandsController {

    @Autowired
    private IBrandUpdateUsecase usecase;

    @PutMapping(value = "/")
    public String updateHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandUpdateRequestData inputData = super.MAPPER.readValue(inputDataJson, BrandUpdateRequestData.class);

            Brands brand = this.usecase.update(userId, inputData);

            BrandResponseViewModel response = BrandResponseViewModel.of(
                    brand.getId(),
                    brand.getUserId(),
                    brand.getName(),
                    brand.getLink(),
                    brand.getImage(),
                    brand.getCountry(),
                    brand.isDeleted()
            );

            return super.MAPPER.writeValueAsString(response);
        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
