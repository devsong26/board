package com.board.infrastructure;

import com.board.infrastructure.web.MembershipClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Disabled
class MembershipClientTest {

    @Autowired
    MembershipClient membershipClient;

    @Test
    public void test(){

        for(int i=1; i<=10; i++){
            System.out.println(i + "번째 시도입니다.");

            String membershipInfo = null;

            try{
                membershipInfo = membershipClient.getMember(1L);
            } catch (Exception onlyTrace){
                System.err.println(onlyTrace.getMessage());
            }

            if(membershipInfo != null){
                System.out.println(membershipInfo);
            }
        }

    }

}