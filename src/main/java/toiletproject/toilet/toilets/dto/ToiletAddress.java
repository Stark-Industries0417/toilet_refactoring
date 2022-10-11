package toiletproject.toilet.toilets.dto;


import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
public class ToiletAddress {
    @NotBlank()
    private String address;
}
