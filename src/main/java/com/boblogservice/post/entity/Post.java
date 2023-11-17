package com.boblogservice.post.entity;

import com.boblogservice.member.entity.Member;
import com.boblogservice.post.dto.PostDto;
import com.boblogservice.series.entity.Series;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

import static com.boblogservice.common.generator.IdGenerator.ENTITY_TYPE;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
@DynamicInsert
public class Post {
    @Id
    @Column(columnDefinition = "varchar(100)", name = "postId")
    @GenericGenerator(
            name = "postId",
            strategy = "com.boblogservice.common.generator.IdGenerator",
            parameters = {
                    @Parameter(name = ENTITY_TYPE, value = "P"),
            }
    )
    @GeneratedValue(generator = "postId")
    private String postId;

    @Column(columnDefinition = "varchar(100)", name = "title", nullable = false)
    private String title;

    @Column(columnDefinition = "LONGTEXT", name = "content", nullable = false)
    private String content;

    @Column(columnDefinition = "LONGTEXT", name = "parsedContent", nullable = false)
    private String parsedContent;

    @Column(name = "createDateTime", nullable = false)
    private LocalDateTime createDateTime;

    @Column(name = "updateDateTime", nullable = false)
    private LocalDateTime updateDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="memId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seriesId")
    private Series series;

    public PostDto toDto() {
        return PostDto.builder()
                .postId(this.getPostId())
                .title(this.getTitle())
                .content(this.getContent())
                .parsedContent(this.getParsedContent())
                .createDateTime(this.getCreateDateTime())
                .updateDateTime(this.getUpdateDateTime())
                .memId(this.getMember().getMemId())
                .memName(this.getMember().getNickname())
                .seriesId(this.getSeries().getSeriesId())
                .build();
    }
}
