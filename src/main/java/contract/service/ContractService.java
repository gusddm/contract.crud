package contract.service;

import java.util.List;

import contract.model.Contract;

public interface ContractService {
	Contract saveOrUpdate(Contract contract);
	List<Contract> findByName(String name);
	List<Contract> findByCityOrState(String city, String state);
	List<Contract> findByEmailOrPhoneNumber(String email, String phoneNumber);
	Contract find(Long id);
	void delete(Long id);
}