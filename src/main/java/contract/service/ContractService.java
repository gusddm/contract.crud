package contract.service;

import java.util.List;
import java.util.Map;

import contract.model.Contract;

public interface ContractService {
	Contract saveOrUpdate(Contract contract);
	List<Contract> findByName(String name);
	Contract find(Long id);
	Contract savePartial(Map<String, Object> updates, Long contractId);
}