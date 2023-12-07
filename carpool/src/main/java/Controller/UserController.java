package Controller;
import Service.UserService;
import jakarta.servlet.http.HttpSession;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    //    @PostMapping("/login")
//    public String login(@RequestParam String userId, @RequestParam String password, HttpSession session) {
//        User user = userService.getUserById(userId);
//
//        if (user != null && user.getPassword().equals(password)) {
//            session.setAttribute("user", user);
//            return "redirect:/dashboard";
//        } else {
//            session.setAttribute("error", "Incorrect credentials. Please try again.");
//            return "redirect:/login";
//        }
//    }
    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password, HttpSession session) {
        User user = userService.getUserById(userId);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        } else {
            session.setAttribute("error", "Incorrect credentials. Please try again.");
            return "redirect:/login";
        }
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, HttpSession session) {
        User existingUser = userService.getUserById(user.getUserID());

        if (existingUser != null) {
            session.setAttribute("msg", "User with ID: " + user.getUserID() + " already exists");
        } else {
            User savedUser = userService.saveUser(user);
            if (savedUser != null) {
                session.setAttribute("msg", "Registration Successful");
            } else {
                session.setAttribute("msg", "Registration Unsuccessful");
            }
        }
        return "redirect:/";
    }

    @PostMapping("/reset-password")
    public String resetPassword(
            @RequestParam String userID,
            @RequestParam String newPassword,
            HttpSession session
    ) {
        // Update the password in the database
        User user = userService.getUserById(userID);

        if (user != null) {
            user.setPassword(newPassword);
            userService.saveUser(user);
            session.setAttribute("msg", "Password reset successfully. Please log in with your new password.");
            return "redirect:/login";
        } else {
            // User not found, show an error message
            session.setAttribute("error", "User not found.");
            return "redirect:/login";
        }
    }
    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot_password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(
            @RequestParam String fullName,
            @RequestParam String userID,
            @RequestParam String phone,
            Model model
    ) {
        // Check if the provided information is correct
        User user = userService.getUserById(userID);

        if (user != null && user.getName().equals(fullName) && user.getPhone().equals(phone)) {
            // Information is correct, proceed to the next step (e.g., enter a new password)
            model.addAttribute("userID", userID);
            return "reset_password";
        } else {
            // Information is incorrect, show an error message
            model.addAttribute("error", "Invalid information. Please try again.");
            return "forgot_password";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/update")
    public String UpdateDetails(@RequestParam String name, @RequestParam String userID, @RequestParam String phone, @RequestParam String password) {
        User user = userService.getUserById(userID);
        if (user != null) {
            user.setName(name);
            user.setUserID(userID);
            user.setPhone(phone);
            user.setPassword(password);
            userService.saveUser(user);
        }
        // Redirect to dashboard
        return "redirect:/dashboard";
    }

    @PostMapping("/delete")
    public String deleteDetails(@RequestParam("userID") String userID) {
        if (userID!=null) {
            userService.deleteUser(userID);
        }
        return "redirect:/";
    }
}
