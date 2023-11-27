package com.hyun.team_maker.repository;

import com.hyun.team_maker.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hyun.team_maker.model.QTestEntity.testEntity;
import static com.querydsl.jpa.JPAExpressions.selectFrom;


@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl implements TestRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    //    @Override
    //    public List<TestEntity> findAllByNameWithQuerydsl(String name) {
    //        return queryFactory
    //                .selectFrom(testEntity) // QTestEntity 사용
    //                .where(testEntity.name.eq(name)) // name으로 필터링
    //                .fetch(); // 조회된 결과 반환
    //    }

    @Override
    public List<TestEntity> findAllByNameWithQuerydsl(String name) {
        return queryFactory
                .selectFrom(testEntity)
                .where(testEntity.name.like("%" + name + "%")) // name에 해당하는 부분을 포함하는 경우 검색
                .fetch();
    }

}
