package com.boblogservice.post.entity;

import com.boblogservice.common.util.CommonUtil;
import com.boblogservice.member.dto.MemberDto;
import com.boblogservice.member.entity.Member;
import com.boblogservice.post.dto.PostDto;
import com.boblogservice.series.entity.Series;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.cglib.core.Local;

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

    @Column(columnDefinition = "varchar(255)", name = "title", nullable = false)
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

    @Column(columnDefinition = "boolean", name = "tmpYn", nullable = false)
    @ColumnDefault("true")
    private Boolean tmpYn;

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
                .seriesId(this.getSeries() == null ? "" : this.getSeries().getSeriesId())
                .tmpYn(this.getTmpYn())
                .build();
    }

    @Builder
    private Post(LocalDateTime createDateTime,
                 LocalDateTime updateDateTime,
                 String title,
                 String content,
                 String parsedContent,
                 Member member,
                 String seriesId,
                 Boolean tmpYn) {
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.title = title;
        this.content = content;
        this.parsedContent = parsedContent;
        this.member = member;
        this.tmpYn = tmpYn;
    }

    public static Post from(PostDto postDto, Member member) {
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .parsedContent(CommonUtil.markdown(postDto.getContent()))
                .createDateTime(LocalDateTime.now())
                .updateDateTime(LocalDateTime.now())
                .member(member)
                .tmpYn(postDto.getTmpYn())
                .build();
    }

    public void updatePost(PostDto postDto) {
        setTitle(postDto.getTitle());
        setContent(postDto.getContent());
        setParsedContent(CommonUtil.markdown(postDto.getContent()));
        setUpdateDateTime(LocalDateTime.now());
//        setSeries();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setParsedContent(String parsedContent) {
        this.parsedContent = parsedContent;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
