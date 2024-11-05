package com.board.infrastructure.mysql;

import com.board.infrastructure.mysql.entity.Inquiry;
import com.board.domain.QInquiry;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InquiryRepository {

    private final JPAQueryFactory queryFactory;

    public InquiryRepository(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Inquiry> findInquiriesByContainsTitle(String title) {
        QInquiry inquiry = QInquiry.inquiry;

        return queryFactory
                .selectFrom(inquiry)
                .where(inquiry.title.contains(title))
                .fetch();
    }

}
