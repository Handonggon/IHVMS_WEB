package kr.or.i815.ihvms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.i815.ihvms.domain.repository.UserRepository;
import kr.or.i815.ihvms.dto.UserDto;
import kr.or.i815.ihvms.dto.UserSearchDto;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<UserDto> findByUserIdLike(String userId) {
        return userRepository.findByUserIdLike("%" + userId + "%").stream().map(user->new UserDto(user)).collect(Collectors.toList());
    }

    public UserDto save(UserDto userDto) {
        return new UserDto(userRepository.save(userDto.toEntity()));
    }

    public List<UserDto> saveAll(List<UserDto> userDtos) {
        return userRepository.saveAll(userDtos.stream().map(userDto->userDto.toEntity()).collect(Collectors.toList())).stream()
                                                                                                                      .map(user->new UserDto(user))
                                                                                                                      .collect(Collectors.toList());
    }

    public UserDto delete(UserSearchDto userSearchDto) {
        UserDto userDto = new UserDto(userRepository.findByUserNo(userSearchDto.getUserNo()));
        userRepository.deleteById(userDto.getUserNo());
        return userDto;
    }

    public List<UserDto> deleteAll(List<UserSearchDto> userSearchDtos) {
        return userSearchDtos.stream().map(userSearchDto->this.delete(userSearchDto)).collect(Collectors.toList());
    }
}