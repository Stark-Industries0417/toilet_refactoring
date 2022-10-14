package toiletproject.toilet.toilets;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toiletproject.toilet.config.auth.PrincipalDetails;
import toiletproject.toilet.toilets.dto.ToiletAddress;
import toiletproject.toilet.toilets.dto.ToiletAround;
import toiletproject.toilet.toilets.dto.ToiletAroundDto;
import toiletproject.toilet.toilets.dto.ToiletDto;
import toiletproject.toilet.user.entity.UserEntity;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/toilets")
@RestController
public class ToiletController {

    private final ToiletService toiletService;

    @PostMapping("additional")
    public ToiletDto addToilet(@AuthenticationPrincipal PrincipalDetails auth,
                     @RequestBody @Valid ToiletDto toiletAddDto) {
        UserEntity user = auth.getUserEntity();
        return toiletService.addToilet(user, toiletAddDto);
    }

    @PostMapping()
    public ToiletDto getToilet(@RequestBody @Valid ToiletAddress addressDto) {
        return toiletService.getToilet(addressDto);
    }

    @PostMapping("around_toilet")
    public List<ToiletAroundDto> aroundToilet(@AuthenticationPrincipal PrincipalDetails auth,
            @RequestBody @Valid ToiletAround aroundDto) {
        UserEntity user = auth.getUserEntity();
        return toiletService.aroundToilet(user, aroundDto);
    }
}
