package kr.or.i815.ihvms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.or.i815.ihvms.domain.model.ADM.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNo(Long userNo);
    List<User> findByUserIdLike(String userId);
}