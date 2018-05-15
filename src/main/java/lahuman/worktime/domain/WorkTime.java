package lahuman.worktime.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "work_time")
@Getter
@Setter
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "worker_id")
    private Long workerId;
    @Column(name = "work_date")
    private String workDate;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;
    @Column(name = "note")
    private String note;
    @Column(name = "reg_user_id")
    private Long regUserId;
    @Column(name = "reg_date")
    private Timestamp regDate;
    @Column(name = "mod_user_id")
    private Long modUserId;
    @Column(name = "mod_date")
    private Timestamp modDate;

    public void setStartTime(LocalTime localTime){
        this.startTime = java.sql.Time.valueOf(localTime);
    }

    public void setEndTime(LocalTime localTime){
        this.endTime = java.sql.Time.valueOf(localTime);
    }

    private WorkTime() {
    }

    public WorkTime(String workDate, Long workerId, LocalTime startTime, Long regUserId) {
        this.workDate = workDate;
        this.workerId = workerId;
        this.startTime = java.sql.Time.valueOf(startTime);
        this.regUserId = regUserId;
        this.regDate = new Timestamp(System.currentTimeMillis());
    }


}
