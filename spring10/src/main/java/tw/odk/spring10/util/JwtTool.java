package tw.odk.spring10.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtTool {
	private static final long EXP_TIME =  10* 60 * 1000;
	private static final String SECURET = "BradChao1234567765431abcdefgDogCat";
	private static final Key key = Keys.hmacShaKeyFor(SECURET.getBytes());
	
	public static String createToken(String subject) {
		String token = Jwts.builder()
			.setSubject(subject)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + EXP_TIME))
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
		return token;
	}
	
	public static String parseToken(String token) {
		//Key sKey = Keys.hmacShaKeyFor(SECURET.getBytes());
		
		JwtParser parser = Jwts.parserBuilder()
							.setSigningKey(key)
							.build();
		Claims claims = parser.parseClaimsJws(token).getBody();
		String subject = claims.getSubject();
		
		return subject;
	}
	
	public static Jws<Claims> parse(String tiken) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(tiken);
	}
	
	public static String fetchAccount(String token) {
		return parse(token).getBody().getSubject();
	}
	
	public static boolean isVaild(String token) {
		try {
			parse(token);
			return true;
		}catch(JwtException e) {
			return false;
		}
	}
	
}