package changgou.test;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;

public class JwtTest {
    @Test
    public void createJwtToken(){
        //设置头部
        JwtBuilder builder = Jwts.builder();
        //设置载荷
        builder.setIssuer("童林").setSubject("某一个数据").setId("镇八方").setIssuedAt(new Date())
        //设置签名
                .signWith(SignatureAlgorithm.HS256,"zimiankunlunxia");
        //拼装生成
        String compact = builder.compact();
        System.out.println(compact);
    }
    @Test
    public void parseJwtToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiLnq6XmnpciLCJzdWIiOiLmn5DkuIDkuKrmlbDmja4iLCJqdGkiOiLplYflhavmlrkiLCJpYXQiOjE2NzAzMjE5NzB9.A-7uQvsMhTmEDbWC6EixBVHZRxcgH8uIjdlW6kmHFF4";
        Jws<Claims> zimiankunlunxia = Jwts.parser().setSigningKey("zimiankunlunxia").parseClaimsJws(token);
        Claims body = zimiankunlunxia.getBody();
        System.out.println(body);

    }
}


