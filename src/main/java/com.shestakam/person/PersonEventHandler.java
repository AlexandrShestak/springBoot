package com.shestakam.person;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Person.class)
public class PersonEventHandler {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @HandleBeforeSave
    public void checkPUTAuthority(Person person) {
// only security check
    }
}