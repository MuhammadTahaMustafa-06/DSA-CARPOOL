package Controller;

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
    public String login(@RequestParam String userId, @RequestParam String password) {
        // Add logic to check login credentials
        // Redirect to appropriate page
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    //Creating new users
    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        //logic to check if the user already exists
        if(userService.getUserById(user.getUserId()) == null) {
            User userDetails = userService.createUser(user);

            if(userDetails != null){
                System.out.println("Register Successfully");
            }
            else{
                System.out.println("Registration Unsuccessfully");
            }
        }

        // Save the user and redirect to login page
        else{
            System.out.println("User with ID: "+user.getUserId()+" already exists");
        }

        return "redirect:/login";
    }
}
