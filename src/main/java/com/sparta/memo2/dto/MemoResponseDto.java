package com.sparta.memo2.dto;

import com.sparta.memo2.entity.Memo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {

    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
        this.createAt = memo.getCreatedAt();
        this.modifiedAt = memo.getModifiedAt();
    }


}
