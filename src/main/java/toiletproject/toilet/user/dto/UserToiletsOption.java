package toiletproject.toilet.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.option.OptionEntity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@NoArgsConstructor
@Getter
public class UserToiletsOption {
    private Boolean common;
    private Boolean locked;
    private Boolean paper;
    private Boolean disabled;

    public UserToiletsOption(OptionEntity option) {
        common = option.getCommon();
        locked = option.getLocked();
        paper = option.getPaper();
        disabled = option.getDisabled();
    }
}
