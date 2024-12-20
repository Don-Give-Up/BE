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

    @Autowired
    public MemberDataLoader(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
            .memberPassword(PasswordUtils.hashPassword("kch4731@naver.com"))
            .memberName("김채호")
            .memberSchool("경신중학교")
            .memberBirthday(LocalDate.of(2001, 1, 24))
            .memberNickname("관리자")
            .memberRole(MemberRole.STUDENT)
            .memberGrade(1)
            .memberClass(1)
            .build();
        memberRepository.save(member1);

        Member member2 = Member.builder()
            .memberEmail("0918syj@naver.com")
            .memberPassword(PasswordUtils.hashPassword("0918syj@naver.com"))
            .memberName("송호진")
            .memberSchool("신창중학교")
            .memberBirthday(LocalDate.of(1999, 7, 29))
            .memberNickname("정보영 선생님")
            .memberRole(MemberRole.STUDENT)
            .memberGrade(1)
            .memberClass(4)
            .build();
        memberRepository.save(member2);

        Member teacher1 = Member.builder()
            .memberEmail("ybd4731@gmail.com")
            .memberPassword(PasswordUtils.hashPassword("ybd4731@gmail.com"))
            .memberName("김채호")
            .memberSchool("경신중학교")
            .memberBirthday(LocalDate.of(2001, 1, 24))
            .memberNickname("박민정 선생님")
            .memberRole(MemberRole.TEACHER)
            .memberGrade(1)
            .memberClass(1)
            .build();
        memberRepository.save(teacher1);

        Member teacher2 = Member.builder()
            .memberEmail("0918syj@gmail.com")
            .memberPassword(PasswordUtils.hashPassword("0918syj@gmail.com"))
            .memberName("송호진")
            .memberSchool("신창중학교")
            .memberBirthday(LocalDate.of(1999, 7, 29))
            .memberNickname("박민주 선생님")
            .memberRole(MemberRole.TEACHER)
            .memberGrade(1)
            .memberClass(4)
            .build();
        memberRepository.save(teacher2);

        Member admin = Member.builder()
            .memberEmail("admin1234@naver.com")
            .memberPassword(PasswordUtils.hashPassword("admin1234@naver.com"))
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
            .memberEmail("meami@gmail.com")
            .memberPassword(PasswordUtils.hashPassword("1234"))
            .memberName("박민주")
            .memberSchool("로딩중")
            .memberBirthday(LocalDate.of(2004, 4, 11))
            .memberNickname("송호진 선생님")
            .memberRole(MemberRole.TEACHER)
            .memberGrade(1)
            .memberClass(4)
            .build();
        memberRepository.save(teacher3);

        Member teacher4 = Member.builder()
            .memberEmail("AI@naver.com")
            .memberPassword(PasswordUtils.hashPassword("AI"))
            .memberName("박민정")
            .memberSchool("AI")
            .memberBirthday(LocalDate.of(2024, 11, 11))
            .memberNickname("AI")
            .memberRole(MemberRole.TEACHER)
            .memberGrade(1)
            .memberClass(1)
            .build();
        memberRepository.save(teacher4);

        Member test1 = Member.builder()
                .memberEmail("test1@example.com")
                .memberPassword(PasswordUtils.hashPassword("1234"))
                .memberName("test1")
                .memberSchool("테스트중")
                .memberBirthday(LocalDate.of(1983, 7, 29))
                .memberNickname("유디니")
                .memberRole(MemberRole.TEACHER)
                .memberGrade(1)
                .memberClass(5)
                .build();
        memberRepository.save(test1);

        Member test2 = Member.builder()
                .memberEmail("test2@example.com")
                .memberPassword(PasswordUtils.hashPassword("1234"))
                .memberName("test2")
                .memberSchool("테스트중")
                .memberBirthday(LocalDate.of(1984, 7, 29))
                .memberNickname("민쮸")
                .memberRole(MemberRole.TEACHER)
                .memberGrade(1)
                .memberClass(6)
                .build();
        memberRepository.save(test2);

        Member test3 = Member.builder()
                .memberEmail("test3@example.com")
                .memberPassword(PasswordUtils.hashPassword("1234"))
                .memberName("test3")
                .memberSchool("테스트중")
                .memberBirthday(LocalDate.of(1985, 7, 29))
                .memberNickname("여워니")
                .memberRole(MemberRole.TEACHER)
                .memberGrade(1)
                .memberClass(7)
                .build();
        memberRepository.save(test3);
    }
}