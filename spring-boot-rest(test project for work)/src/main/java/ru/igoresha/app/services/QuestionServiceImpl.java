package ru.igoresha.app.services;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.igoresha.app.exceptions.NotFoundException;
import ru.igoresha.app.forms.QuestionForm;
import ru.igoresha.app.models.Interview;
import ru.igoresha.app.models.Question;
import ru.igoresha.app.repositories.InterviewRepository;
import ru.igoresha.app.repositories.QuestionRepository;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    /**
     * @param idI id Interview, need to find Interview object by id
     * @param questions questions list need to find max value of displayOrder
     * @return max value of displayOrder, if question list is empty max value = 0
     */
    private int getQuestionMaxDisplayOrderByInterviewId(Long idI, List<Question> questions) {
        int max = 0;
        if (!questions.isEmpty()) {
            for (Question q :
                    questions) {
                if (q.getDisplayOrder() > max) {
                    max = q.getDisplayOrder();
                }
            }
        }
        return max;
    }

    @Override
    public Page<Question> findAll(Long idI, Pageable pageable) {
        if (!interviewRepository.existsById(idI)) {
            throw new NotFoundException();
        }
        return questionRepository.findAllByInterviewIdOrderByDisplayOrderAsc(idI, pageable);
    }

    /**
     * @param idI Interview id
     * @param questionForm need to create new Question object
     * @return Question object with incremented displayOrder
     */
    @Override
    public Question addQuestion(Long idI, QuestionForm questionForm) {
        if (!interviewRepository.existsById(idI)) {
            throw new NotFoundException();
        }
        Interview interview = interviewRepository.getOne(idI);
        if (interview instanceof HibernateProxy) {
            interview = (Interview) ((HibernateProxy) interview).getHibernateLazyInitializer().getImplementation();
        }
        List<Question> questions = questionRepository.findAllByInterviewId(idI);
        int maxDisplayOrder = getQuestionMaxDisplayOrderByInterviewId(idI, questions);
        Question question = Question.builder()
                .text(questionForm.getText())
                .displayOrder(maxDisplayOrder + 1)
                .interview(interview)
                .build();
        return questionRepository.save(question);
    }


    @Override
    public Question get(Long idI, Integer displayOrder) {
        if (!interviewRepository.existsById(idI) || questionRepository.findByInterviewIdAndDisplayOrder(idI, displayOrder) == null) {
            throw new NotFoundException();
        }
        Question question = questionRepository.findByInterviewIdAndDisplayOrder(idI, displayOrder);
        if (question instanceof HibernateProxy) {
            return (Question) ((HibernateProxy) question).getHibernateLazyInitializer().getImplementation();
        }
        return question;
    }

    @Override
    public Question update(Long idI, Integer displayOrder, QuestionForm questionForm) {
        if (!interviewRepository.existsById(idI) || questionRepository.findByInterviewIdAndDisplayOrder(idI, displayOrder) == null) {
            throw new NotFoundException();
        }
        Question question = questionRepository.findByInterviewIdAndDisplayOrder(idI, displayOrder);
        if (question instanceof HibernateProxy) {
            question = (Question) ((HibernateProxy) question).getHibernateLazyInitializer().getImplementation();
        }
        question.setText(questionForm.getText());
        return questionRepository.save(question);
    }

    @Override
    public void delete(Long idI, Integer displayOrder) {
        if (!interviewRepository.existsById(idI) || questionRepository.findByInterviewIdAndDisplayOrder(idI, displayOrder) == null) {
            throw new NotFoundException();
        }
        Question question = questionRepository.findByInterviewIdAndDisplayOrder(idI, displayOrder);
        questionRepository.deleteById(question.getId());
    }
}
