package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RiderController {

    @GetMapping("/rider")
    public String rider() {
        return "rider";
    }

    // Add methods for rider-related operations as needed
}

