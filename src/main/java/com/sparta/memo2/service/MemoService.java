package com.sparta.memo2.service;

import com.sparta.memo2.dto.MemoRequestDto;
import com.sparta.memo2.dto.MemoResponseDto;
import com.sparta.memo2.entity.Memo;
import com.sparta.memo2.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // DB 저장
        Memo memo =  memoRepository.save( Memo.of(requestDto));
        // Entity -> ResponseDto
        return MemoResponseDto.of(memo);
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> getMemos() {
        // DB 조회
        return memoRepository.findByOrderByModifiedAtDesc()
                .stream()
                .map(MemoResponseDto::of) // 메서드 참조를 사용하여 MemoResponseDto.of()를 호출
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> getMemosByKeyword(String keyword) {

        return memoRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword)
                .stream()
                .map(MemoResponseDto::of) // 메서드 참조를 사용하여 MemoResponseDto.of()를 호출
                .toList();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = findMemo(id);
        memo.update(requestDto);
        return id;
    }

    @Transactional
    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);
        memoRepository.delete(memo);
        return id;

    }

    private Memo findMemo(Long id){
        return memoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }

}
