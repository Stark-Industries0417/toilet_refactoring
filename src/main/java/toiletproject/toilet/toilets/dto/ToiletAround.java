package toiletproject.toilet.toilets.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class ToiletAround {
    @NotNull
    private double lat;

    @NotNull
    private double lng;

    @NotNull
    private double dist;
}
