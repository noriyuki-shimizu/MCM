package source.usecases.dto.request.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.domain.entity.Images;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ImageUpdateRequestModel {
    private Long id;

    private String path;

    public Images toEntity() {
        return Images.builder()
                .id(this.id)
                .path(this.path)
                .build();
    }
}
