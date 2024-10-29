package org.example.demo.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.example.demo.study.domain.Member;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.common.BaseEntity;
import org.example.demo.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission misson;

}
