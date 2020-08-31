package ru.igoresha.app.forms;

import lombok.Data;
import ru.igoresha.app.models.Interview;

@Data
public class QuestionForm {

    private Interview interview;
    private String text;
    private Byte displayOrder; //порядок отображения
}
