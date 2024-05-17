package com.homepage.likelion.member.service;

import com.homepage.likelion.domain.Member;
import com.homepage.likelion.member.dto.MemberSignInDto;
import com.homepage.likelion.member.dto.MemberSignUpDto;
import com.homepage.likelion.member.repository.MemberRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 1. 회원 가입
    @Transactional // 삽입 연산은 트랜젝션 내부에서 수행되어야 한다.
    public ResponseEntity<CustomApiResponse<?>> signUp(MemberSignUpDto memberSignUpDto) {
        // 1. 사용자가 회원가입에 요청한 아이디가 DB에 존재하는지 확인
        String userId = memberSignUpDto.getUserId();
        Optional<Member> findedMember = memberRepository.findByUserId(userId);

        // 존재한다면 -> 회원가입 허용 x
        if(findedMember.isPresent()){
            CustomApiResponse<Object> failReponse
                    = CustomApiResponse.createFailWithoutData(HttpStatus.BAD_REQUEST.value(), "이미 사용중인 아이디입니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failReponse);
        }

        // 2. 존재하지 않는다면 회원가입 수행
        // 회원 객체 생성 후 값 할당
        Member newMember = Member.builder()
                .userId(memberSignUpDto.getUserId())
                .password(memberSignUpDto.getPassword())
                .phone(memberSignUpDto.getPhone())
                .email(memberSignUpDto.getEmail())
                .build();
        memberRepository.save(newMember); // 회원 저장

        return ResponseEntity.status(HttpStatus.OK.value())
                .body(CustomApiResponse.createSuccess(HttpStatus.OK.value(), null, "회원가입에 성공하였습니다."));
    }

    // 2. 로그인
    public ResponseEntity<CustomApiResponse<?>> signIn(MemberSignInDto memberSignInDto) {

        // 1. 회원이 DB에 존재하는지 확인
        Optional<Member> findedMember = memberRepository.findByUserId(memberSignInDto.getUserId());

        // DB에 회원이 존재하지 않는다면
        if(findedMember.isEmpty()){
            return memberNotFound();
        }

        // 2. DB에 저장된 비밀번호와 사용자가 로그인에 요청한 비밀번호가 일치하는지 확인
        // 일치하지 않는다면
        if(!memberSignInDto.getPassword().equals(findedMember.get().getPassword())){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(CustomApiResponse.createFailWithoutData(HttpStatus.UNAUTHORIZED.value(), "비밀번호가 일치하지 않습니다."));
        }

        // 모든 확인 절차를 통과하였다면 로그인 허용
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSuccess(HttpStatus.OK.value(),null,"로그인에 성공하였습니다."));
    }

    // 3. 회원 탈퇴
    @Transactional // 삭제 연산은 트랜젝션 내부에서 수행되어야 한다.
    public ResponseEntity<CustomApiResponse<?>> withdrawMember(String userId) {

        // 1. DB에 존재하는 회원인지 확인
        Optional<Member> findedMember = memberRepository.findByUserId(userId);

        // 존재하지 않는 회원이라면
        if(findedMember.isEmpty()){
            return memberNotFound();
        }

        // 2. DB에서 해당 회원 삭제
        memberRepository.delete(findedMember.get());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSuccess(HttpStatus.OK.value(),null,"회원이 정상적으로 탈퇴되었습니다"));
    }

    // 일치하는 회원이 없을 경우 404 에러 반환
    private static ResponseEntity<CustomApiResponse<?>> memberNotFound() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(CustomApiResponse.createFailWithoutData(HttpStatus.NOT_FOUND.value(), "존재하지 않는 회원입니다."));
    }
}
