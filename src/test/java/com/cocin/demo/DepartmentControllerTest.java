package com.cocin.demo;

import com.cocin.demo.employee.Department;
import com.cocin.demo.employee.DepartmentController;
import com.cocin.demo.employee.DepartmentRequest;
import com.cocin.demo.employee.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {

    @InjectMocks
    private DepartmentController departmentController;

    @Mock
    private DepartmentService departmentService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    }

    @Test
    public void testGetDepartment() throws Exception {
        // Mocking a department
        Department department = new Department();
        department.setId(1L);
        department.setName("IT");
        department.setDescription("Information Technology");

        // Mocking the departmentService to return the department
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(Optional.of(department));

        // Sending a GET request to "/api/departments/1"
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("IT"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Information Technology"));
    }

    @Test
    public void testCreateDepartment() throws Exception {
        // Creating a department request object
        DepartmentRequest departmentRequest = new DepartmentRequest("HR", "Human Resources");


        // Mocking the departmentService to return the created department
        Department createdDepartment = new Department();
        createdDepartment.setId(2L);
        createdDepartment.setName("HR");
        createdDepartment.setDescription("Human Resources");
        Mockito.when(departmentService.createDepartment(Mockito.any(DepartmentRequest.class))).thenReturn(createdDepartment);

        // Sending a POST request to "/api/departments"
        mockMvc.perform(MockMvcRequestBuilders.post("/api/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"HR\",\"description\":\"Human Resources\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("HR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Human Resources"));
    }
}
