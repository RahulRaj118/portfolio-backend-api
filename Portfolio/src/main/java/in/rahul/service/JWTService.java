package in.rahul.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import in.rahul.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	
	private String secretKey="";
	public JWTService() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keyGenerator.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());			
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Some error occur "+e.getMessage());
		}
	}
	private SecretKey getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	public String generateToken(String email,User user) {
		
		Map<String, Object> claim = new HashMap<>();
		claim.put("role", user.getRole());
		claim.put("email",user.getUsername() );
		
		
		return Jwts.builder()
				.claims()
				.add(claim)
				.subject(email)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*60*60))
				.and()
				.signWith(getKey())
				.compact();
	}
	
	
	
	public String extractUserEmail(String token) {
		Claims claims = Jwts.parser()
				.verifyWith(getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
		return claims.getSubject();
	}
	

	public Date extractExpiration(String token) {
	    Claims claims = Jwts.parser()
	            .verifyWith(getKey())
	            .build()
	            .parseSignedClaims(token)
	            .getPayload();

	    return claims.getExpiration();
	}

	private boolean isTokenExpired(String token) {
	    return extractExpiration(token).before(new Date());
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		  String usernameFromToken = extractUserEmail(token);

		    return usernameFromToken.equals(userDetails.getUsername())
		            && !isTokenExpired(token);
	}
}
