package ru.igoresha.app.services;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.igoresha.app.exceptions.NotFoundException;
import ru.igoresha.app.forms.InterviewForm;
import ru.igoresha.app.models.Interview;
import ru.igoresha.app.repositories.InterviewRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param string date in String format
     * @return date in Date format, if try to parse is false throw NotFoundException with status 404
     */
    private Date castStringToDate(String string) {
        try {
            return DATE_FORMAT.parse(string);
        } catch (ParseException e) {
            throw new NotFoundException();
        }
    }

    /**
     * @param string string need to convert to Boolean
     * @return converting boolean result
     */
    private Boolean castStringToBoolean(String string) {
        return string.equals("true") || string.equals("1");
    }


    @Override
    public Page<Interview> getPagesBySortAndDirectionAndFilter(String sortBy,
                                                               String direction,
                                                               String filterBy,
                                                               String value,
                                                               Pageable pageable) {

        if (sortBy == null || value == null) {
            return interviewRepository.findAll(pageable);
        }
        switch (sortBy) {
            case "name":
                switch (filterBy) {
                    case "name":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByNameContainsOrderByNameDesc(value, pageable) :
                                interviewRepository.findAllByNameContainsOrderByNameAsc(value, pageable);
                    case "dateBegin":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByDateBeginOrderByNameDesc(castStringToDate(value), pageable) :
                                interviewRepository.findAllByDateBeginOrderByNameAsc(castStringToDate(value), pageable);
                    case "dateEnd":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByDateEndOrderByNameDesc(castStringToDate(value), pageable) :
                                interviewRepository.findAllByDateEndOrderByNameAsc(castStringToDate(value), pageable);
                    case "isActive":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByIsActiveOrderByNameDesc(castStringToBoolean(value), pageable) :
                                interviewRepository.findAllByIsActiveOrderByNameAsc(castStringToBoolean(value), pageable);
                }
            case "dateBegin":
                switch (filterBy) {
                    case "name":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByNameContainsOrderByDateBeginDesc(value, pageable) :
                                interviewRepository.findAllByNameContainsOrderByDateBeginAsc(value, pageable);
                    case "dateBegin":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByDateBeginOrderByDateBeginDesc(castStringToDate(value), pageable) :
                                interviewRepository.findAllByDateBeginOrderByDateBeginAsc(castStringToDate(value), pageable);
                    case "dateEnd":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByDateEndOrderByDateBeginDesc(castStringToDate(value), pageable) :
                                interviewRepository.findAllByDateEndOrderByDateBeginAsc(castStringToDate(value), pageable);
                    case "isActive":
                        return direction.equals("desc") ?
                                interviewRepository.findAllByIsActiveOrderByDateBeginDesc(castStringToBoolean(value), pageable) :
                                interviewRepository.findAllByIsActiveOrderByDateBeginAsc(castStringToBoolean(value), pageable);
                }
        }
        return interviewRepository.findAll(pageable);
    }

    @Override
    public Interview addInterview(InterviewForm interviewForm) {
        Interview interview = Interview.builder()
                .dateBegin(interviewForm.getDateBegin())
                .dateEnd(interviewForm.getDateEnd())
                .isActive(interviewForm.getIsActive())
                .name(interviewForm.getName())
                .build();
        interviewRepository.save(interview);
        return interview;
    }

    @Override
    public Interview update(Long id, InterviewForm interviewForm) {
        Interview interview1 = this.get(id);
        interview1.setDateBegin(interviewForm.getDateBegin());
        interview1.setDateEnd(interviewForm.getDateEnd());
        interview1.setIsActive(interviewForm.getIsActive());
        interview1.setName(interviewForm.getName());
        return interview1;
    }

    @Override
    public void delete(Long id) {
        interviewRepository.deleteById(id);
    }

    @Override
    public Interview get(Long id) {
        if (!interviewRepository.existsById(id)) {
            throw new NotFoundException();
        }
        Interview interview = interviewRepository.getOne(id);
        if (interview instanceof HibernateProxy) {
            return (Interview) ((HibernateProxy) interview).getHibernateLazyInitializer().getImplementation();
        }
        return interview;
    }
}
