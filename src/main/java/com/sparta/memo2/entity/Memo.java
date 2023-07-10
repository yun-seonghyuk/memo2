package com.sparta.memo2.entity;

import com.sparta.memo2.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Memo {

    private Long id;
    private String useranme;
    private String contents;

    public Memo(MemoRequestDto requestDto) {
        this.useranme = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.useranme = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
