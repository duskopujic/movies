package com.lanaco.movies.Utils;

import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Repository.UsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtUtil {

@Value("${jwt.secret}")

    private String SECRET_KEY;

    private LocalDateTime expirationDate;

    @Autowired
    private UsersRepository usersRepository;

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public Date extractExpiration(String token){
    return extractClaim(token,Claims::getExpiration);
    }
    public <T> T extractClaim(String token, Function<Claims,T>claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        Optional<Users>users=usersRepository.findByUserName(userDetails.getUsername());
        claims.put("userId",users.get().getUserId());
        claims.put("firstName",users.get().firstName);
        claims.put("lastName",users.get().lastName);
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(setTokenExpirationDate(1))
            .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Date setTokenExpirationDate(int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,years);
        return calendar.getTime();
    }

}
