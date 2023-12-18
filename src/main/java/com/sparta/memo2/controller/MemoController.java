package com.sparta.memo2.controller;

import com.sparta.memo2.dto.MemoRequestDto;
import com.sparta.memo2.dto.MemoResponseDto;
import com.sparta.memo2.service.MemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Slf4j
public class MemoController {

    private final MemoService memoService;

    @GetMapping("memos/contents")
    public List<MemoResponseDto> getMemosByKeyword(@RequestParam String keyword){

        return memoService.getMemosByKeyword(keyword);
    }


    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        return  memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        return memoService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id,requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }
}