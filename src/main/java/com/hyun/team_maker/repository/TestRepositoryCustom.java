package com.hyun.team_maker.repository;

import com.hyun.team_maker.model.TestEntity;

import java.util.List;

public interface TestRepositoryCustom {
    public List<TestEntity> findAllByNameWithQuerydsl(String name);
}
