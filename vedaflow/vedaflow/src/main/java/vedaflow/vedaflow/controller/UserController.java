package vedaflow.vedaflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vedaflow.vedaflow.DTO.LoginBody;
import vedaflow.vedaflow.DTO.RegisterBody;
import vedaflow.vedaflow.repository.UserRepository;
import vedaflow.vedaflow.services.UserService;
import vedaflow.vedaflow.user.MyUserDetailService;
import vedaflow.vedaflow.utils.JwtUtils;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody RegisterBody body){
        String jwt=userService.register(body);
        return ResponseEntity.ok(Map.of("token",jwt));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody LoginBody body){
        String jwt= userService.login(body);
        return ResponseEntity.ok(Map.of("token",jwt));
    }
    
}
