package com.sitespace.fileupload.usermanagement;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Serializable> {

	Optional<Role> findByName(ERole name);

}
