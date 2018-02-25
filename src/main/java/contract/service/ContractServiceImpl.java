package contract.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contract.model.Contract;
import contract.model.repository.ContractRepository;

@Transactional
@Service
public class ContractServiceImpl implements ContractService {
	
	public enum CONTRACT_FIELDS {NAME, COMPANY, IMAGE, EMAIL, BIRTHDAY, PHONE_NUMBER}

	@Autowired
	private transient ContractRepository contractRepository;

	@Override
	public Contract saveOrUpdate(Contract contract) { 
		return contractRepository.save(contract);
	}

	@Override
	public List<Contract> findByName(String name) {
		return contractRepository.findByName(name);
	}
	
	@Override
	public Contract find(Long id) {		
		return contractRepository.findOne(id);
	}

	@Override
	public List<Contract> findByCityOrState(String city, String state) {		
		return contractRepository.findByAddressesCityOrAddressesState(city, state);
	}

	@Override
	public void delete(Long id) {
		contractRepository.delete(id);
	}
}