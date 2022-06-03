package Springtest2.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
                                    //JPA 리포지토리 클래스로부터 상속<엔티티명, pk 자료형>
}
