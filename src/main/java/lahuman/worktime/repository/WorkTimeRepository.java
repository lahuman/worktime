package lahuman.worktime.repository;

import lahuman.worktime.domain.WorkTime;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface WorkTimeRepository extends CrudRepository<WorkTime, Long> {

    WorkTime findByWorkDateAndWorkerId(String workDate, Long workerId);
}
