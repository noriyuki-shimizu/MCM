package source.domain.vo;

import lombok.Value;

import java.util.Collections;
import java.util.List;

@Value(staticConstructor = "of")
public class ImageAddresses {
    private List<String> values;

    public ImageAddresses chooseRamdom() {
        Collections.shuffle(this.values);
        return ImageAddresses.of(this.values.subList(0, 8));
    }
}
