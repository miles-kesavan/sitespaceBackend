package com.sitespace.fileupload.security;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sitespace.fileupload.userMaster.userMasterService;
import com.sitespace.fileupload.usermanagement.ERole;
import com.sitespace.fileupload.usermanagement.Role;
import com.sitespace.fileupload.usermanagement.RoleRepository;
import com.sitespace.fileupload.usermanagement.SignupRequest;
import com.sitespace.fileupload.usermanagement.User;
import com.sitespace.fileupload.usermanagement.UserDetailsImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags="Authentication", description="Manages Authentication operation")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private userMasterService userMasterService;

	@Autowired
	RoleRepository roleRepository;
	

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@ApiOperation(value = "Sign In")
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		System.out.println(encoder.encode(loginRequest.getPassword()));
		
		String jwt = "";
		


		//loginRequest.setPassword(jwtUtils.decrypt(loginRequest.getPassword()));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		


		SecurityContextHolder.getContext().setAuthentication(authentication);
		 jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
//				.collect(Collectors.toList());
	

		
		
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getUserId(), userDetails.getUsername(), userDetails.getEmail(),userDetails.getRole() ));
	}

	@ApiOperation(value = "Get user info by token")
	@GetMapping("/userbytoken")
	public Optional<User> getUserDetail(@RequestParam("token") String jwtToken) throws Exception {
		Optional<User> userDetails = null;
		if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {
			String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
			userDetails = userMasterService.getEmployeeUserName(username);
			userDetails.get().setPassword(null);

		}
		return userDetails;
	}

	@ApiOperation(value = "Sign Up")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//		}
//
//		// Create new user's account
//		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
//				encoder.encode(signUpRequest.getPassword()));
//
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//
//		user.setRoles(roles);
//		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	@ApiOperation(value = "Sign Out")
	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
	    // On client side, remove the token. Here we just return a success response.
	    return ResponseEntity.ok(new MessageResponse("User signed out successfully!"));
	}
}
