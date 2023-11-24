package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DriverController {

    @GetMapping("/driver")
    public String driver() {
        return "driver";
    }

    // Add methods for driver-related operations as needed
}
