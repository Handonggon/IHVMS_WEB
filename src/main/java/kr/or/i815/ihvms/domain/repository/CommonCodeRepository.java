package kr.or.i815.ihvms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.or.i815.ihvms.domain.model.ADM.CommonCode;
import kr.or.i815.ihvms.domain.model.ADM.CommonCodeId;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, CommonCodeId> {

}