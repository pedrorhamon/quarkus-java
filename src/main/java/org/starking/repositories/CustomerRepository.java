package org.starking.repositories;

import javax.enterprise.context.ApplicationScoped;

import org.starking.entities.CustomerEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<CustomerEntity>{

}
