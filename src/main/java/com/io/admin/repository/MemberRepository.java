package com.io.admin.repository;

import com.io.admin.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{


}
