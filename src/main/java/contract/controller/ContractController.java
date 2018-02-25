package contract.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import contract.configuration.patch.Patch;
import contract.configuration.patch.PatchRequestBody;
import contract.model.Contract;
import contract.service.ContractService;

@RestController
@RequestMapping(value = "/contract")
public class ContractController {

  @Autowired
  ContractService contractService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getContract(@PathVariable final Long id) {
    final Contract person = contractService.find(id);
    if (person == null) {
      return ResponseEntity.notFound().build();
    }
    final Resource<Contract> resource = new Resource<Contract>(person);
    resource.add(linkTo(methodOn(ContractController.class).getContract(id)).withSelfRel());

    return ResponseEntity.ok(resource);
  }
  
  @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getContract(@PathVariable final String name) {
    final List<Contract> contractList = contractService.findByName(name);
    if (contractList == null) {
      return ResponseEntity.notFound().build();
    }
    final Resources<Contract> resource = new Resources<>(contractList);
    resource.add(linkTo(methodOn(ContractController.class).getContract(name)).withSelfRel());

    return ResponseEntity.ok(resource);
  }
  
  @RequestMapping(value = "/address", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getContractByCity(@RequestParam(value = "city", required = false) final String city, 
		  												   @RequestParam(value = "state", required = false) final String state) {
	
	final List<Contract> contractList = contractService.findByCityOrState(city, state);

	if (contractList == null) {
		return ResponseEntity.notFound().build();
	}

	final Resources<Contract> resource = new Resources<>(contractList);
    resource.add(linkTo(methodOn(ContractController.class).getContractByCity(city, state)).withSelfRel());

    return ResponseEntity.ok(resource);
  }
  
  
  /**
   * Contract partial update.
   * @return Contract
   */
  @PatchMapping(value = "/{id}")
  @Patch(service = ContractService.class, id = Long.class)
  @ResponseBody public ResponseEntity<?> updateContract(@PathVariable final Long id,  @PatchRequestBody Contract contract) {
    
    final Contract persistedContract = contractService.saveOrUpdate(contract);
    
    final Resource<Contract> resource = new Resource<Contract>(persistedContract);
    resource.add(linkTo(methodOn(ContractController.class).getContract(id)).withSelfRel());

    return ResponseEntity.ok(resource);
  }

  /**
   * Contract creation.
   * @return Contract
   */
  @RequestMapping(value = "/", method = RequestMethod.PUT)
  @ResponseBody public ResponseEntity<?> saveContract(@RequestBody final Contract contract) {
	
	final Contract persistedContract = contractService.saveOrUpdate(contract);	
    
    final Resource<Contract> resource = new Resource<Contract>(persistedContract);
    resource.add(
        linkTo(methodOn(ContractController.class).getContract(persistedContract.getId())).withSelfRel()
    );
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .contentType(MediaType.APPLICATION_JSON)
        .body(resource);
  }
  
  /**
   * Contract creation.
   * @return Contract
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody public BodyBuilder deleteContract(@PathVariable final Long id) {	
	contractService.delete(id);    
	return ResponseEntity.ok();
  }	
}