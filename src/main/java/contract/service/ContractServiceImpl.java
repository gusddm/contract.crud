package contract.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

//	@Override
//	public Contract saveOrUpdate(Contract contract) {
//		
//		
//		return contractRepository.save(contract)

//		List<CONTRACT_FIELDS> updateKey = updates.keySet().stream()
//															.map(key -> key.toUpperCase())
//															.map(key -> CONTRACT_FIELDS.valueOf(key))
//															.collect(Collectors.toList());						
//		updateKey.stream().forEach(key -> );
//		fillContractData(contract, updateKeys, updates);
		
		
//	}
	
	private Contract fillContractData(Contract contract, CONTRACT_FIELDS updateKey, Map<String, Object> updates) {
		switch(updateKey) {
			case BIRTHDAY :
				contract.setBirthdate( (Date)updates.get(CONTRACT_FIELDS.BIRTHDAY.toString().toLowerCase()) );
			case NAME:
				contract.setName( updates.get(CONTRACT_FIELDS.NAME.toString().toLowerCase()).toString() );
			case COMPANY:
				contract.setCompany( updates.get(CONTRACT_FIELDS.COMPANY.toString().toLowerCase()).toString() );
			case EMAIL:
				contract.setEmail( updates.get(CONTRACT_FIELDS.EMAIL.toString().toLowerCase()).toString() );
			case IMAGE:
				contract.setImage( updates.get(CONTRACT_FIELDS.IMAGE.toString().toLowerCase()).toString() );
			case PHONE_NUMBER:
				contract.setPhone_number( updates.get(CONTRACT_FIELDS.PHONE_NUMBER.toString().toLowerCase()).toString() );
			default:
				break;	
		}
		return contract;
	}

	@Override
	public Contract savePartial(Map<String, Object> updates, Long contractId) {
		// TODO Auto-generated method stub
		return null;
	}


}
