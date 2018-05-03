package lahuman.worktime.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name="work_time")
@Getter @Setter
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "work_date")
    private Date workDate;

    @Column(name = "start_time")
    private Time startTIme;

    @Column(name = "end_time")
    private Time endTIme;

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


}
