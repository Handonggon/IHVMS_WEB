package kr.or.i815.ihvms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.i815.ihvms.domain.repository.CommonCodeRepository;
import kr.or.i815.ihvms.dto.CommonCodeDto;

@Service
public class CommonCodeService {

    @Autowired
    private CommonCodeRepository commonCodeRepository;
    
    public List<CommonCodeDto> findAll() {
        List<CommonCodeDto> commonCode = new ArrayList<>();
        commonCodeRepository.findAll().forEach(row -> commonCode.add(new CommonCodeDto(row)));
        return commonCode;
    }
}