package lahuman.worktime.controller;

import lahuman.worktime.domain.User;
import lahuman.worktime.domain.WorkTime;
import lahuman.worktime.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/worktime")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @RequestMapping(value = "/work", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<WorkTime> getWrok() {
        return userService.findAllWorkTime();
    }

    @RequestMapping(value = "/work", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public void checkInWork() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userService.findByUsername(principal.toString());

            String today = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now());
            WorkTime wt = userService.findByWorkDateAndWorkerId(
                    today
                    , user.getId());

            if (wt == null){
                wt = new WorkTime(today, user.getId(),  LocalTime.now(), user.getId());
            }else{
                wt.setEndTime(LocalTime.now());
                wt.setModUserId(user.getId());
                wt.setModDate(new Timestamp(System.currentTimeMillis()));
            }
            userService.saveWorkTime(wt);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }
}
