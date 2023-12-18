package com.sparta.memo2.entity;

import com.sparta.memo2.dto.MemoRequestDto;
import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "memo") // 매핑할 테이블의 이름을 지정
@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    public static Memo of(MemoRequestDto requestDto) {
        return Memo.builder()
                .username(requestDto.getUsername())
                .contents(requestDto.getContents())
                .build();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}