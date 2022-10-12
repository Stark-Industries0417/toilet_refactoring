package toiletproject.toilet.review.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class ReviewAddDto {

    @NotBlank
    private String address;

    @NotBlank
    private String content;

    @NotNull
    private Integer rate;

    @NotNull
    private Boolean common;

    @NotNull
    private Boolean locked;

    private List<Integer> types;

    @NotNull
    private Boolean paper;

    @NotNull
    private Boolean disabled;
}
