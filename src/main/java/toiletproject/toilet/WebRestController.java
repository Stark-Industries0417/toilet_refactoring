package toiletproject.toilet;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @Value("${spring.config.activate.on-profile}")
    private String set;

    @GetMapping("/profile")
    public String getSet(){
        return set;
    }
}
