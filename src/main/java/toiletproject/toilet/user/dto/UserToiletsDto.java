package toiletproject.toilet.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import toiletproject.toilet.toilets.entity.ToiletEntity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;


@NoArgsConstructor
@Getter @Setter
public class UserToiletsDto {

    private String address;
    private String detailAddress;
    private int category;
    private int subway;
    private double lat;
    private double lng;
    private int stack;
    private double clean;
    private UserToiletsOption option;




    public UserToiletsDto(ToiletEntity toilet) {
        address = toilet.getAddress();
        detailAddress = toilet.getDetailAddress();
        category = toilet.getCategory();
        subway = toilet.getSubway();
        lat = toilet.getLat();
        lng = toilet.getLng();
        stack = toilet.getStack();
        clean = toilet.getClean();
        option = new UserToiletsOption(toilet.getOption());
    }
}
