package com.shestakam.configuration;

import com.shestakam.person.PersonRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

@Configuration
@EnableJpaRepositories(basePackageClasses = {PersonRepository.class})
public class PersistenceConfiguration extends JpaRepositoryConfigExtension {
// I added some code to put two persons into the database here.
}