package com.sparta.memo2.repository;

import com.sparta.memo2.dto.MemoResponseDto;
import com.sparta.memo2.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByOrderByModifiedAtDesc();
    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
//    List<Memo> findAllByUsername(String username);
}
