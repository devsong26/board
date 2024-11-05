package com.board.infrastructure.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class MembershipClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "membershipCircuitBreaker", fallbackMethod = "fallbackGetMember")
    public String getMember(long memberId){

        return restTemplate.getForObject("http://localhost:8081/member/" + memberId, String.class);
    }

    @SuppressWarnings("unused")
    private String fallbackGetMember(long memberId, Throwable t) {
        log.error("[Membership API Server Error] {} 회원의 정보를 조회하는데 실패했습니다. >> {}", memberId, t.getMessage());
        return "회원 정보를 조회하는데 실패했습니다.";
    }

}
