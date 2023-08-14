package com.example.demo;

import com.example.demo.repository.JdbcMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {

    //spring이 자체적으로 주입
    private DataSource dataSource;

    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
