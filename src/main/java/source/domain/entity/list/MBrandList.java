package source.domain.entity.list;

import lombok.Value;
import source.domain.dto.assist.BrandOutputData;
import source.domain.entity.MBrand;

import java.util.List;
import java.util.stream.Collectors;

@Value(staticConstructor = "of")
public class MBrandList {

    private List<MBrand> values;

    public List<BrandOutputData> convertAssistBrandOutputData() {

        return this.values.stream().map(value -> {
            return BrandOutputData.of(value.getId(), value.getName());
        }).collect(Collectors.toList());

    }
}
