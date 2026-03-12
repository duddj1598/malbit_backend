package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "use_dictionary")
public class UseDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dictId; //사전ID (PK)

    // 어떤 사용자의 사전인지 연결 (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String slurPattern; //오인식 발음

    @Column(nullable = false)
    private String correctWord; //올바른 단어

    @Column(nullable = false)
    private Integer useCount = 0; // 활용 횟수 (기본값 0)

    @Builder
    public UseDictionary(User user, String slurPattern, String correctWord, Integer useCount) {
        this.user = user;
        this.slurPattern = slurPattern;
        this.correctWord = correctWord;
        this.useCount = (useCount != null) ? useCount : 0;
    }
}


