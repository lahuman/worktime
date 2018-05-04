package lahuman.worktime.controller;

import lahuman.worktime.domain.User;
import lahuman.worktime.domain.WorkTime;
import lahuman.worktime.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worktime")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @RequestMapping(value ="/work", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<WorkTime> getWrok(){
        return userService.findAllWorkTime();
    }

    @RequestMapping(value ="/work", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public void checkInWork(){
        if(SecurityContextHolder.getContext().getAuthentication() != null ){
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if ( principal instanceof UserDetails) {
                System.out.println(((UserDetails)principal).getUsername());
            }
        }
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
}
