package com.virtukch.dongiveupbe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"localCreate", "devCreate", "prod"})  // 필요한 프로파일 설정
class DonGiveUpBeApplicationTests {

    @Test
    void contextLoads() {
    }

}
