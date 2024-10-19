package com.virtukch.dongiveupbe.member.repository;

import com.virtukch.dongiveupbe.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}