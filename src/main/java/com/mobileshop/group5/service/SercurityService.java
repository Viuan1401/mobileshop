package com.mobileshop.group5.service;

import com.mobileshop.group5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SercurityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())){
            return false;
        }
        return authentication.isAuthenticated();
    }
}
