package contract.controller.test;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import contract.controller.ContractController;
import contract.model.Address;
import contract.model.Contract;
import contract.service.ContractService;

@WebMvcTest(controllers = ContractController.class)
@RunWith(SpringRunner.class)
public class ContractControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@MockBean
    private ContractService contractServiceMock;

    @Test
    public void testList() throws Exception {

    	java.util.Date utilDate = new java.util.Date(); //fecha actual
    	long lnMilisegundos = utilDate.getTime();
    	Timestamp date = new java.sql.Timestamp(lnMilisegundos);
    	
    	Contract contract = new Contract();
    	contract.setName("Johny");
    	contract.setBirthdate(Date.valueOf("1981-10-12"));
    	contract.setCompany("");
    	contract.setEmail("");
    	contract.setId(Long.getLong("1"));
    	contract.setImage("");
    	contract.setPhone_number("");
    	contract.setCreatedAt(date);
    	contract.setUpdatedAt(date);
   	 	

   		Contract contract2 = new Contract();
   		contract2.setName("Johny");
    	contract2.setBirthdate(Date.valueOf("1991-03-12"));
    	contract2.setCompany("");
    	contract2.setEmail("");
    	contract2.setId(Long.getLong("1"));
    	contract2.setImage("");
    	contract2.setPhone_number("");
    	contract2.setCreatedAt(date);
    	contract2.setUpdatedAt(date);
   	 	
    	Address address = new Address();
    	address.setCity("loma");
    	address.setContract(contract);
    	address.setPostal_code("1234");
    	address.setState("acanoma");
    	address.setAddress("calle falsa 123");
    	
    	Address address2 = new Address();
    	address.setCity("hermosa");
    	address.setContract(contract2);
    	
    	List<Address> addresses = Arrays.asList(address, address2);
    	
    	contract.setAddresses(addresses);
    	contract2.setAddresses(addresses);

   	 	List<Contract> contractList = Arrays.asList(contract, contract2);

   	 	given(contractServiceMock.findByCityOrState("loma", null)).willReturn(contractList);
    	
        mockMvc.perform(get("/contract/address?city=loma"))
                .andExpect(status().isOk())
                //.andExpect(content().string("loma"));                
                .andExpect(jsonPath("$..*.contracts.*", hasSize(2)));
    }
}