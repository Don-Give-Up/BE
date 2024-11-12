package com.virtukch.dongiveupbe.security.member.dataloader;

import com.virtukch.dongiveupbe.security.member.repository.MemberRepository;
import com.virtukch.dongiveupbe.security.member.entity.Member;
import com.virtukch.dongiveupbe.security.member.entity.MemberRole;
import com.virtukch.dongiveupbe.security.member.utils.PasswordUtils;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class MemberDataLoader implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final PasswordUtils passwordUtils;

    @Autowired
    public MemberDataLoader(MemberRepository memberRepository, PasswordUtils passwordUtils) {
        this.memberRepository = memberRepository;
        this.passwordUtils = passwordUtils;
    }

    // local (ddl-auto: none, DataLoader 작동 X)
    // localCreate (ddl-auto: create, DataLoader 작동 O)
    // dev (ddl-auto: none, DataLoader 작동 X)
    // devCreate (ddl-auto: create, DataLoader 작동 O)
    // prod (ddl-auto: create, DataLoader 작동 O)
    @Override
    public void run(String... args) throws Exception {
        Member member1 = Member.builder()
            .memberEmail("kch4731@naver.com")
            .memberPassword(passwordUtils.hashPassword("kch4731@naver.com"))
            .memberName("김채호")
            .memberSchool("경신중학교")
            .memberBirthday(LocalDate.of(2001, 1, 24))
            .memberNickname("채채핑")
            .memberRole(MemberRole.STUDENT)
            .memberGrade(1)
            .memberClass(1)
            .build();
        memberRepository.save(member1);

        Member member2 = Member.builder()
            .memberEmail("0918syj@naver.com")
            .memberPassword(passwordUtils.hashPassword("0918syj@naver.com"))
            .memberName("송호진")
            .memberSchool("신창중학교")
            .memberBirthday(LocalDate.of(1999, 7, 29))
            .memberNickname("호진희")
            .memberRole(MemberRole.STUDENT)
            .memberGrade(1)
            .memberClass(4)
            .build();
        memberRepository.save(member2);

        Member teacher1 = Member.builder()
            .memberEmail("ybd4731@gmail.com")
            .memberPassword(passwordUtils.hashPassword("ybd4731@gmail.com"))
            .memberName("김채호")
            .memberSchool("경신중학교")
            .memberBirthday(LocalDate.of(2001, 1, 24))
            .memberNickname("채채핑담임")
            .memberRole(MemberRole.TEACHER)
            .memberGrade(1)
            .memberClass(1)
            .build();
        memberRepository.save(teacher1);

        Member teacher2 = Member.builder()
            .memberEmail("0918syj@gmail.com")
            .memberPassword(passwordUtils.hashPassword("0918syj@gmail.com"))
            .memberName("송호진")
            .memberSchool("신창중학교")
            .memberBirthday(LocalDate.of(1999, 7, 29))
            .memberNickname("호진희담임")
            .memberRole(MemberRole.TEACHER)
            .memberGrade(1)
            .memberClass(4)
            .build();
        memberRepository.save(teacher2);

        Member admin = Member.builder()
            .memberEmail("admin1234@naver.com")
            .memberPassword(passwordUtils.hashPassword("admin1234@naver.com"))
            .memberName("admin")
            .memberSchool("ADMIN")
            .memberBirthday(LocalDate.now())
            .memberNickname("admin")
            .memberRole(MemberRole.ADMIN)
            .memberGrade(1234)
            .memberClass(1234)
            .build();
        memberRepository.save(admin);

        Member teacher3 = Member.builder()
                .memberEmail("qkralswn306@naver.com")
                .memberPassword(passwordUtils.hashPassword("1234"))
                .memberName("박민주")
                .memberSchool("로딩중")
                .memberBirthday(LocalDate.of(2004, 4, 11))
                .memberNickname("박민쥬라기공원")
                .memberRole(MemberRole.TEACHER)
                .memberGrade(1)
                .memberClass(4)
                .build();
        memberRepository.save(teacher3);
    }
}