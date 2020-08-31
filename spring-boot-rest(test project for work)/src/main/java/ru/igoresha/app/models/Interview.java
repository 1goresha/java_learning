package ru.igoresha.app.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateBegin;

    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    private Boolean isActive;

    @OneToMany(mappedBy = "interview")
    private List<Question> questions;

}
