package cu.edu.cujae.loginservice.jwt;


import cu.edu.cujae.loginservice.responseDTO.NetworkResponse;
import cu.edu.cujae.loginservice.responseDTO.UserResponse;
import cu.edu.cujae.loginservice.utils.NetworkUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

import static cu.edu.cujae.loginservice.constants.JWTConstants.JWT_KEY;
import static cu.edu.cujae.loginservice.constants.JWTConstants.JWT_SECRET_KEY;
import static cu.edu.cujae.loginservice.constants.JWTConstants.VALIDITYINMILLISECONDS;

@Component
public class JwtTokenProvider {
    @Autowired
    JwtProperties jwtProperties;

    private String secretKey;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(JWT_SECRET_KEY.getBytes());
    }

    public String createToken(UserResponse response, HttpServletRequest request){
        NetworkResponse networkResponse = NetworkUtils.getDeviceAddresses.apply(request);

        return Jwts.builder()
                .setSubject(response.getUsername())                
                .claim("mac",networkResponse.getMacAddress())
                .claim("ip",networkResponse.getIpAddress())
                .setIssuer(JWT_KEY)
                .setExpiration(calculateExpirationDate())
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .compact();
    }

    private Date calculateExpirationDate(){
        Date now = new Date();
        return new Date(now.getTime()+VALIDITYINMILLISECONDS);
    }
}
