package com.board.infrastructure.mysql;

import com.board.domain.Inquiry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("dev")
class InquiryRepositoryTest {

    @Autowired
    InquiryRepository inquiryRepository;

    @Test
    public void test_findInquiriesByTitle(){
        // Given
        final String title = "테스트";

        // When
        final List<Inquiry> inquiries = inquiryRepository.findInquiriesByContainsTitle(title);

        // Then
        assertEquals(1, inquiries.size());
    }

}