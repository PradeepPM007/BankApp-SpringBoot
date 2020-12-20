//package application;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import application.bll.CustomerManager;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TestCustomController {
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private CustomerManager customManager;
//	
//    
//	@Test
//	public void Customer_basic() throws Exception {
//		
//		when(customManager.findAll()).thenReturn(
//				Arrays.asList()
//				);
//		
//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/all-items-from-database")
//				.accept(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json("[]"))
//				.andReturn();
//	
//	}
//	
//}