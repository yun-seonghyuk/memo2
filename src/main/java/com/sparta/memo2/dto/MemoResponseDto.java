package com.sparta.memo2.dto;

import com.sparta.memo2.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoResponseDto {

    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public static MemoResponseDto of (Memo memo) {
        return MemoResponseDto.builder()
                .id(memo.getId())
                .username(memo.getUsername())
                .createAt(memo.getCreatedAt())
                .contents(memo.getContents())
                .modifiedAt(memo.getModifiedAt())
                .build();
    }



}
