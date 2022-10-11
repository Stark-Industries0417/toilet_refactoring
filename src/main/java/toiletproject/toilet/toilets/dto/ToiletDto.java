package toiletproject.toilet.toilets.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.toilets.entity.ToiletEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter @Setter
public class ToiletDto {

    @NotBlank()
    private String address;
    private String detailAddress;

    private int category;

    private int subway;

    @NotNull
    private double lat;
    @NotNull
    private double lng;

    public ToiletDto(ToiletEntity toilet) {
        this.address = toilet.getAddress();
        this.detailAddress = toilet.getDetailAddress();
        this.category = toilet.getCategory();
        this.subway = toilet.getSubway();
        this.lat = toilet.getLat();
        this.lng = toilet.getLng();
    }
}
