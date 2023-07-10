package com.sparta.memo2.dto;

import com.sparta.memo2.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {

    private Long id;
    private String username;
    private String contents;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUseranme();
        this.contents = memo.getContents();
    }
}
