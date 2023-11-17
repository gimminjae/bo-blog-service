package com.boblogservice.series.entity;

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
@Table(name = "series")
@NoArgsConstructor
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class Series {
    @Id
    @Column(columnDefinition = "varchar(100)", name = "seriesId")
    @GenericGenerator(
            name = "seriesId",
            strategy = "com.boblogservice.common.generator.IdGenerator",
            parameters = {
                    @Parameter(name = ENTITY_TYPE, value = "S"),
            }
    )
    @GeneratedValue(generator = "seriesId")
    private String seriesId;
    @Column(columnDefinition = "varchar(50)", name = "name", nullable = false)
    private String name;
    @Column(name = "createDateTime", nullable = false)
    private LocalDateTime createDateTime;
}
