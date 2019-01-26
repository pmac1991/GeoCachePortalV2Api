package com.pm.GeoCachePortalV2Api.Services;

import com.pm.GeoCachePortalV2Api.Exceptions.NoUserInSecuirtyContextException;
import com.pm.GeoCachePortalV2Api.Models.ApplicationUser.ApplicationUser;
import com.pm.GeoCachePortalV2Api.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUser getCurrentUserFromSecurityContext() throws UsernameNotFoundException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = null;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if(username == null){
            throw(new NoUserInSecuirtyContextException("No user in security context"));
        }

        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

        if(applicationUser == null){
            throw(new UsernameNotFoundException("Username: " + username + " not found"));
        }

        return applicationUser;
    }

}
