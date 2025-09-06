package vedaflow.vedaflow.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vedaflow.vedaflow.DTO.LoginBody;
import vedaflow.vedaflow.DTO.RegisterBody;
import vedaflow.vedaflow.exception.UserAlreadyExistException;
import vedaflow.vedaflow.exception.UserNotFoundException;
import vedaflow.vedaflow.repository.UserRepository;
import vedaflow.vedaflow.user.MyUserDetailService;
import vedaflow.vedaflow.user.UserModel;
import vedaflow.vedaflow.utils.JwtUtils;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyUserDetailService userDetailService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    private AuthenticationManager authenticationManager;
    public String register(RegisterBody body){
        if (userRepository.findByEmail(body.getEmail()).isPresent()){
            throw new UserAlreadyExistException("Email already Exists");
        }
        if (userRepository.findByUsername(body.getUsername()).isPresent()){
            throw new UserAlreadyExistException("Username Already Exists");
        }
        UserModel user=new UserModel();
        user.setEmail(body.getEmail());
        user.setUsername(body.getUsername());
        user.setPassword(passwordEncoder.encode(body.getPassword()));

        UserModel savedUser=userRepository.save(user);
        UserDetails userDetails= userDetailService.loadUserByUsername(savedUser.getUsername());
        String jwt=jwtUtils.generateToken(savedUser.getUsername());
        return jwt;
    }
    public String login(LoginBody body){
        UserModel user=userRepository.findByEmail(body.getEmail())
                .orElseThrow(()-> new UserNotFoundException("User not Found"));
        String username= user.getUsername();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,body.getPassword()));
        }catch (Exception e){
            throw new BadCredentialsException("Username or Password Incorrect");
        }

        UserDetails userDetails= userDetailService.loadUserByUsername(username);
        String jwt=jwtUtils.generateToken(userDetails.getUsername());
        return jwt;
    }
    public List<UserModel> getByUsername(String username){
        List<UserModel> users=userRepository.searchByUsername(username);
        return users;
    }
}
