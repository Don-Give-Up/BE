package com.virtukch.dongiveupbe.security.member.repository;

import com.virtukch.dongiveupbe.security.member.entity.Member;
import com.virtukch.dongiveupbe.security.member.repository.projection.MemberNickname;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberEmail(String memberEmail);

    MemberNickname findMemberNicknameByMemberId(Long memberId);
}