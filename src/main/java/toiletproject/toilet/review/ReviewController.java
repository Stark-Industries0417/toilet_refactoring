package toiletproject.toilet.review;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import toiletproject.toilet.config.auth.PrincipalDetails;
import toiletproject.toilet.review.dto.ReviewAddDto;
import toiletproject.toilet.review.dto.ReviewResDto;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("additional")
    public ReviewResDto reviewAdditional(
            @AuthenticationPrincipal PrincipalDetails auth,
            @RequestBody @Valid ReviewAddDto reviewAddDto) {
        return reviewService.reviewAdditional(auth, reviewAddDto);
    }
}
