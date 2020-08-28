package ru.igoresha.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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

    private Date castStringToDate(String string){
        try {
            return DATE_FORMAT.parse(string);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }


    @Override
    public Page<Interview> getPagesBySortAndDirectionAndFilter(String sort,
                                                               String direction,
                                                               String selectAll,
                                                               String where,
                                                               Pageable pageable) {

        Page<Interview> result = interviewRepository.findAll(pageable);
        Date dateBegin;
        Date dateEnd;

        switch (sort) {
            case "name":
                switch (selectAll) {
                    case "name":
                        return direction.equals("desc")?
                                interviewRepository.findAllByNameContainsOrderByNameDesc(where, pageable):
                                interviewRepository.findAllByNameContainsOrderByNameAsc(where, pageable);
                    case "dateBegin":
                        return direction.equals("desc")?
                                interviewRepository.findAllByDateBeginOrderByNameDesc(castStringToDate(where), pageable):
                                interviewRepository.findAllByDateBeginOrderByNameAsc(castStringToDate(where), pageable);
                    case "dateEnd":
                        return direction.equals("desc")?
                                interviewRepository.findAllByDateEndOrderByNameDesc(castStringToDate(where), pageable):
                                interviewRepository.findAllByDateEndOrderByNameAsc(castStringToDate(where), pageable);
                }
            case "dateBegin":
                switch (selectAll) {
                    case "name":
                        return direction.equals("desc")?
                                interviewRepository.findAllByNameContainsOrderByDateBeginDesc(where, pageable):
                                interviewRepository.findAllByNameContainsOrderByDateBeginAsc(where, pageable);
                    case "dateBegin":
                        return direction.equals("desc")?
                                interviewRepository.findAllByDateBeginOrderByDateBeginDesc(castStringToDate(where), pageable):
                                interviewRepository.findAllByDateBeginOrderByDateBeginAsc(castStringToDate(where), pageable);
                    case "dateEnd":
                        return  direction.equals("desc")?
                                interviewRepository.findAllByDateEndOrderByDateBeginDesc(castStringToDate(where), pageable):
                                interviewRepository.findAllByDateEndOrderByDateBeginAsc(castStringToDate(where), pageable);
                }
        }


        return result;
    }
}
