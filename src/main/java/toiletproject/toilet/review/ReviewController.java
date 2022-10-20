package toiletproject.toilet.review;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import toiletproject.toilet.config.auth.PrincipalDetails;
import toiletproject.toilet.config.aws.ImageUploadService;
import toiletproject.toilet.review.dto.ReviewAddDto;
import toiletproject.toilet.review.dto.ReviewResDto;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@RestController
public class ReviewController {
    private final ReviewService reviewService;
    private final ImageUploadService imageUploadService;
    private String toiletImg = null;

    @Synchronized
    @PostMapping("additional")
    public ReviewResDto reviewAdditional(
            @AuthenticationPrincipal PrincipalDetails auth,
            @RequestBody @Valid ReviewAddDto reviewAddDto) {
        ReviewResDto reviewResDto = reviewService.reviewAdditional(auth, reviewAddDto, toiletImg);
        toiletImg = null;
        return reviewResDto;
    }

    @GetMapping("/upload")
    public void uploadToS3(@RequestPart MultipartFile image) {
        toiletImg = imageUploadService.uploadImage(image, "toilet");
    }

    @GetMapping("/report/{reviewId}")
    public ReviewResDto reportReview(@PathVariable("reviewId") Long reviewId) throws InterruptedException {
        return reviewService.reportReview(reviewId);
    }
}
