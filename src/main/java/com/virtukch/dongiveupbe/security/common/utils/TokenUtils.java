package com.virtukch.dongiveupbe.security.common.utils;

import com.virtukch.dongiveupbe.security.member.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TokenUtils {

    private static String jwtSecretKey; // JWT 서명에 사용되는 비밀 키
    private static Long tokenValidateTime; // 토큰의 유효 시간

    @Value("${jwt.key}")
    public void setJwtSecretKey(String jwtSecretKey) {
        TokenUtils.jwtSecretKey = jwtSecretKey; // JWT 비밀 키 설정
    }

    @Value("${jwt.time}")
    public void setTokenValidateTime(Long tokenValidateTime) {
        TokenUtils.tokenValidateTime = tokenValidateTime; // 토큰 유효 시간 설정
    }

    /**
     * Authorization 헤더에서 토큰을 분리하는 메서드입니다.
     *
     * @param header Authorization 헤더의 값
     * @return 토큰 부분을 반환합니다.
     */
    public static String splitHeader(String header) {
        if (!header.isEmpty()) {
            return header.split(" ")[1]; // "Bearer <token>" 형식에서 <token> 부분 반환
        } else {
            return null; // 헤더가 비어 있는 경우 null 반환
        }
    }

    /**
     * 주어진 토큰이 유효한지 확인하는 메서드입니다.
     *
     * @param token 확인할 JWT 토큰
     * @return 유효 여부
     * @throws ExpiredJwtException, JwtException, NullPointerException
     */
    public static boolean isValidToken(String token) {
        log.info(token);
        try {
            getClaimsFromToken(token); // 토큰에서 클레임을 추출하여 유효성 검사
            return true; // 유효한 경우 true 반환
        } catch (ExpiredJwtException e) {
            log.info(e.getMessage());
            return false; // 만료된 토큰인 경우 false 반환
        } catch (JwtException e) {
            log.info(e.getMessage());
            return false; // JWT 관련 예외 발생 시 false 반환
        } catch (NullPointerException e) {
            log.info(e.getMessage());
            return false; // null 인 경우 false 반환
        }
    }

    /**
     * request 를 파라미터로 받아 Request 를 보낸 사용자의 Token 을 받아 오는 메서드입니다.
     *
     * @return memberId
     */
    public static String getMemberToken(HttpServletRequest request) {
        return TokenUtils.splitHeader(request.getHeader("Authorization"));
    }

    /**
     * 주어진 토큰을 복호화하여 클레임을 반환하는 메서드입니다.
     *
     * @param token 복호화할 JWT 토큰
     * @return Claims 객체
     */
    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecretKey))
            .parseClaimsJws(token).getBody(); // 토큰을 파싱하여 클레임 반환
    }

    /**
     * request 를 파라미터로 받아 Request 를 보낸 사용자의 Token 을 통해 Claims 을 받아 오는 메서드입니다.
     *
     * @param request 사용자의 request
     * @return Claims 객체
     */
    public static Claims getClaimsFromRequest(HttpServletRequest request) {
        return TokenUtils.getClaimsFromToken(TokenUtils.getMemberToken(request));
    }

    /**
     * 주어진 사용자에 대한 JWT 토큰을 생성하는 메서드입니다.
     *
     * @param user 사용자 엔티티
     * @return 생성된 JWT 토큰
     */
    public static String generateJwtToken(Member member) {
        Date expireTime = new Date(System.currentTimeMillis() + tokenValidateTime); // 만료 시간 설정
        JwtBuilder builder = Jwts.builder()
            .setHeader(createHeader()) // 헤더 설정
            .setClaims(createClaims(member)) // 클레임 설정
            .setSubject("token : " + member.getMemberId()) // 주제 설정
            .signWith(SignatureAlgorithm.HS256, createSignature()) // 서명 설정
            .setExpiration(expireTime); // 만료 시간 설정
        return builder.compact(); // JWT 토큰 생성
    }

    /**
     * JWT 토큰의 헤더를 설정하는 메서드입니다.
     *
     * @return 헤더 설정 정보를 포함한 Map
     */
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("type", "jwt"); // 헤더 타입 설정
        header.put("alg", "HS256"); // 서명 알고리즘 설정
        header.put("date", System.currentTimeMillis()); // 현재 시간 설정
        return header;
    }

    /**
     * 주어진 사용자 정보를 기반으로 클레임을 생성하는 메서드입니다.
     *
     * @param member 사용자 정보
     * @return 클레임 정보가 포함된 Map
     */
    private static Map<String, Object> createClaims(Member member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("memberId", member.getMemberId());
        claims.put("memberEmail", member.getMemberEmail());
        claims.put("memberName", member.getMemberName());
        claims.put("memberSchool", member.getMemberSchool());
        claims.put("memberNickname", member.getMemberNickname());
        claims.put("memberRole", member.getMemberRole());
        claims.put("memberGrade", member.getMemberGrade());
        claims.put("memberClass", member.getMemberClass());
        return claims;
    }

    /**
     * JWT 서명을 생성하는 메서드입니다.
     *
     * @return JWT 서명에 사용되는 키
     */
    private static Key createSignature() {
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey); // 비밀 키 변환
        return new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName()); // 서명 키 생성
    }
}