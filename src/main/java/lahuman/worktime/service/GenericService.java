package lahuman.worktime.service;

import lahuman.worktime.domain.User;
import lahuman.worktime.domain.WorkTime;
import lahuman.worktime.repository.UserRepository;
import lahuman.worktime.repository.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service
public class GenericService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkTimeRepository workTimeRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<WorkTime> findAllWorkTime() {
        return (List<WorkTime>) workTimeRepository.findAll();
    }

    public WorkTime findByWorkDateAndWorkerId(String workDate, Long workId){
        return workTimeRepository.findByWorkDateAndWorkerId(workDate, workId);
    }

    public void saveWorkTime(WorkTime wt){
        workTimeRepository.save(wt);
    }
}
