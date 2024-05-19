package tw.com.nichiai.wealth.domain;

import org.springframework.data.repository.CrudRepository;

//不接露 API
//@RepositoryRestResource(exported = false)
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
