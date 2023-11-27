package com.hyun.team_maker.service;
import com.hyun.team_maker.model.TestEntity;
import com.hyun.team_maker.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TestService {
    private final TestRepository testRepository;

    public void create(String name, Integer age) {
        TestEntity testEntity = new TestEntity(name, age);
        testRepository.save(testEntity);
    }

    public boolean delete(Long id) {
        // id로 해당 엔티티를 조회 한뒤
        Optional<TestEntity> optionalTestEntity = testRepository.findById(id);

        if (optionalTestEntity.isPresent()) {
            // 삭제 하기
            testRepository.delete(optionalTestEntity.get());
            return true; // 삭제 성공
        } else {
            return false; // 엔터티를 찾지 못함
        }
    }

    public boolean update(Long id, String name, Integer age) {
        Optional<TestEntity> optionalTestEntity = testRepository.findById(id);
        if (optionalTestEntity.isPresent()) {
            TestEntity testEntity = optionalTestEntity.get();
            testEntity.changeNameAndAge(name, age);
            testRepository.save(testEntity);
            return true; // 업데이트 성공 시 true 반환
        }
        return false; // 엔티티가 없을 경우 false 반환
    }

    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return testRepository.findAllByNameWithQuerydsl(name);
    }

}
