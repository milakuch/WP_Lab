package mk.ukim.finki.wp;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class WpLab1ApplicationTests {

    MockMvc mockMvc;


    @Autowired
    CourseService courseService;

    private static boolean dataInitialized = false;

    @BeforeEach
    public void setup(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        initData();
    }

    private void initData() {
        if (!dataInitialized) {

            Course course = new Course("Kurs 1","desc",new ArrayList<Student>());
            courseService.addCourse(course);
            dataInitialized = true;
        }
    }


    @Test
    public void testGetCourse() throws Exception {
        MockHttpServletRequestBuilder productRequest = MockMvcRequestBuilders.get("/coursesList");
        this.mockMvc.perform(productRequest)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("courses"))
                .andExpect(MockMvcResultMatchers.view().name("lab2/listCoursesAnonymous"));

    }

    @Test
    void contextLoads() {
    }

}
