package contract.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import contract.model.Contract;

/** Repository manager for Person. */
@Repository
public interface ContractRepository extends PagingAndSortingRepository<Contract, Long> {

  /** Get collections of Person by name. */
  List<Contract> findByName(@Param("name") String name);
  
}
