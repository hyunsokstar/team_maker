package com.hyun.team_maker.repository;

import com.hyun.team_maker.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom  {
}
