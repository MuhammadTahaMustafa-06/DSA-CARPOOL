package Controller;

import jakarta.servlet.http.HttpSession;
import model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password, HttpSession session) {

//        Login Logic
//        It first checks if the user with the given userId exists in the database.
//        If the user exists, it compares the provided password with the stored password.
//        If the passwords match, it redirects to the dashboard.
//        If the passwords don't match, it sets an error message and redirects to the login page.
//        If the user doesn't exist, it redirects to the registration page.

        User user = userService.getUserById(userId);

        if(user != null){
            if(user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                return "redirect:/dashboard";
            }
            else{
                session.setAttribute("error", "Incorrect password. Please try again.");
                return "redirect:/login";
            }
        }
        else {
            // User doesn't exist, redirect to the registration page
            return "redirect:/register";
        }

    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            // You can now use the 'user' object in the dashboard
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            // Redirect to login if the user is not authenticated
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    //Creating new users
    @PostMapping("/register")
    public String register(@ModelAttribute User user, HttpSession session) {
        //logic to check if the user already exists
        if(userService.getUserById(user.getUserId()) == null) {
            User userDetails = userService.createUser(user);

            if(userDetails != null){

                session.setAttribute("msg","Register Successfully");
            }
            else{
                session.setAttribute("msg","Registration Unsuccessfully");
            }
        }

        // Save the user and redirect to login page
        else{
            session.setAttribute("msg","User with ID: "+user.getUserId()+" already exists");
        }

        return "redirect:/login";
    }
}
