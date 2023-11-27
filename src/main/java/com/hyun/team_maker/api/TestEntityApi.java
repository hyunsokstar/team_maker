package com.hyun.team_maker.api;

import com.hyun.team_maker.model.TestEntity;
import com.hyun.team_maker.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TestEntityApi {
    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEnttity(
            @RequestBody CreateTestEntityRequest request
    ) {
        //   testService.create("hyun", 20);
        testService.create(request.getName(), request.getAge());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateTestEntityRequest {
        private String name;
        private Integer age;
    }

    @DeleteMapping("/test/entity/{id}")
    public ResponseEntity<String> deleteTestEntity(
            @PathVariable Long id
    ) {
        System.out.println("id to delete : " + id);

        //  testService.delete(id);
        boolean deleted = testService.delete(id);

        if (deleted) {
            return ResponseEntity.ok("Entity with id " + id + " deleted successfully");
        } else {
            // 값이 없을 경우 응답
            String errorMessage = "Entity with id " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }

    // 컨트롤러 수정
    @PutMapping("/test/entity/{id}")
    public ResponseEntity<?> updateTestEntity(
            @PathVariable Long id,
            @RequestBody UpdateTestEntityRequest request
    ) {
        System.out.println("TestEntity Update Request Check !!");
        boolean updated = testService.update(id, request.getName(), request.getAge());

        if (updated) {
            UpdatedTestEntityResponse response = new UpdatedTestEntityResponse("Entity with id " + id + " updated successfully");
            return ResponseEntity.ok(response);
        } else {
            String errorMessage = "Entity with id " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdatedTestEntityResponse {
        private String message;
    }

    // 컨트롤러에서 사용할 DTO
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateTestEntityRequest {
        private String name;
        private Integer age;
    }

    //    @GetMapping("/test/entities/search-by-name/{name}")
    //    public List<TestEntity> getEntitiesByName(@PathVariable String name) {
    //        return testService.findAllByNameByQuerydsl(name);
    //    }

    @GetMapping("/test/TestEntity/search-by-name/{name}")
    public List<TestEntity> SearchByNameForTestEntity(@PathVariable String name) {
        return testService.findAllByNameByQuerydsl(name);
    }

}
