package ru.igoresha.app.forms;


import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class InterviewForm {

    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateBegin;

    @Temporal(TemporalType.DATE)
    private Date dateEnd;

    private Boolean isActive;
}
