package source.controller.brands.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.brands.BrandsController;
import source.domain.entity.Brands;
import source.usecases.dto.request.brands.BrandSearchRequestData;
import source.usecases.app.brands.IBrandSearchUsecase;
import source.usecases.dto.response.brands.BrandResponseViewModel;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BrandsSearchController extends BrandsController {

    @Autowired
    private IBrandSearchUsecase usecase;

    @GetMapping(value = "/")
    public String searchHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            BrandSearchRequestData inputData = super.MAPPER.readValue(inputDataJson, BrandSearchRequestData.class);

            List<Brands> brands = this.usecase.search(userId, inputData);

            List<BrandResponseViewModel> result = brands.stream()
                    .map(brand -> BrandResponseViewModel.of(
                                brand.getId(),
                                brand.getUserId(),
                                brand.getName(),
                                brand.getLink(),
                                brand.getImage(),
                                brand.getCountry(),
                                brand.isDeleted()
                        )
                    )
                    .collect(Collectors.toList());
            return super.MAPPER.writeValueAsString(result);

        } catch (JsonProcessingException jpe) {
            log.error("JSON の変換エラー", jpe);

            return null;
        } catch (IOException ioe) {
            log.error("JSON の読み込みエラー", ioe);

            return null;
        }
    }
}
