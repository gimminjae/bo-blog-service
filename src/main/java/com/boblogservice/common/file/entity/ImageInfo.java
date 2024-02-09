package com.boblogservice.common.file.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

import static com.boblogservice.common.generator.IdGenerator.ENTITY_TYPE;

@Entity
@Getter
@Table(name = "imageInfo")
@NoArgsConstructor
public class ImageInfo {
    @Id
    @Column(columnDefinition = "varchar(100)", name = "imageId")
    @GenericGenerator(
            name = "imageId",
            strategy = "com.boblogservice.common.generator.IdGenerator",
            parameters = {
                    @Parameter(name = ENTITY_TYPE, value = "I"),
            }
    )
    @GeneratedValue(generator = "imageId")
    private String imageId;

    @Column(columnDefinition = "datetime", name = "createDateTime")
    private LocalDateTime createDateTime;

    @Column(columnDefinition = "varchar(255)", name = "imageUrl")
    private String imageUrl;

    @Column(columnDefinition = "varchar(100)", name = "postId")
    private String postId;

    @Column(columnDefinition = "varchar(100)", name = "memId")
    private String memId;
}
