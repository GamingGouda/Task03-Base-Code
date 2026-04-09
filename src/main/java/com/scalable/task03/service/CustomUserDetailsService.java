package com.scalable.task03.service;

import com.scalable.task03.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: See Task 3 spec — CustomUserDetailsService.

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        throw new UsernameNotFoundException("Not implemented");
    }
}
