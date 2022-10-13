package toiletproject.toilet.toilets.dto;

import java.util.List;

public interface ToiletAroundDto {

    Long getToilet_id();
    String getAddress();
    String getDetailAddress();
    int getCategory();
    int getSubway();
    double getLat();
    double getLng();
    int getStack();
    double getClean();
    Long getUser_id();
    Long getO_id();
    Boolean getCommon();
    Boolean getLocked();
    Boolean getPaper();
    Boolean getDisabled();
    List<Integer> getTypes();
}
