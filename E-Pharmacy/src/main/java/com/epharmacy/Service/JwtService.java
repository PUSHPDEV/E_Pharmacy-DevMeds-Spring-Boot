package com.epharmacy.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.epharmacy.Entity.JwtRequest;
import com.epharmacy.Entity.JwtResponse;
import com.epharmacy.Entity.User;
import com.epharmacy.Repository.UserRepo;
import com.epharmacy.Util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtUtil jwtUtil;

//	@Autowired
//	private AuthenticationManager authenticationManager;

	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
//		authenticate(userName, userPassword);

		UserDetails userDetails = loadUserByUsername(userName);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);

		User user = userRepo.findById(userName).get();
		return new JwtResponse(user, newGeneratedToken);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findById(username).get();

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUserName(),
					user.getUserPassword(),
					getAuthority(user)

			);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);

		}

	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;

	}

//	private void authenticate(String userName, String userPassword) throws Exception {
//
//		try {
//
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
//		} catch (DisabledException e) {
//			throw new Exception("User is disabled",e);
//		} catch (BadCredentialsException  e){
//			throw new Exception("Bad Credentials from user",e);
//		}
//
//	}
}
