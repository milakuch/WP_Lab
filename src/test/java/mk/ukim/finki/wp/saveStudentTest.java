package mk.ukim.finki.wp;


import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.repository.jpa.CourseRepository1;
import mk.ukim.finki.wp.repository.jpa.StudentRepository1;
import mk.ukim.finki.wp.service.StudentService;
import mk.ukim.finki.wp.service.impl.CourseServiceImpl;
import mk.ukim.finki.wp.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(MockitoJUnitRunner.class)
public class saveStudentTest {
    @Mock
    private StudentRepository1 st;

    private StudentServiceImpl studentServiceImpl;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Student student = new Student ("username","password","name","surname");

        Mockito.when(this.st.save(Mockito.any(Student.class))).thenReturn(student);

        this.studentServiceImpl = Mockito.spy(new StudentServiceImpl(this.st));
    }

    @Test
    public void testSuccessSave(){
        Student student = this.studentServiceImpl.save("username","password","name","surname");
        Mockito.verify(this.studentServiceImpl).save("username","password","name","surname");

        Assert.assertNotNull("Student is null", student);
        Assert.assertEquals("username does not match", "username", student.getUsername());
        Assert.assertEquals("password does not match", "password", student.getPassword());
        Assert.assertEquals("name does not match", "name", student.getName());
        Assert.assertEquals("surname does not match", "surname", student.getSurname());

    }

    @Test
    public void testNullUsername() {
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save(null, "password", "name", "surname"));
        Mockito.verify(this.studentServiceImpl).save(null, "password", "name", "surname");
    }

    @Test
    public void testEmptyUsername() {
        String username = "";
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save(username, "password", "name", "surname"));
        Mockito.verify(this.studentServiceImpl).save(username, "password", "name", "surname");
    }

    @Test
    public void testNullPassword() {
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save("username", null, "name", "surname"));
        Mockito.verify(this.studentServiceImpl).save("username", null, "name", "surname");
    }

    @Test
    public void testEmptyPassword() {
        String password = "";
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save("username", password, "name", "surname"));
        Mockito.verify(this.studentServiceImpl).save("username", password, "name", "surname");
    }


    @Test
    public void testNullName() {
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save("username", "password", null, "surname"));
        Mockito.verify(this.studentServiceImpl).save("username", "password", null, "surname");
    }

    @Test
    public void testEmptyName() {
        String name = "";
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save("username", "password", name, "surname"));
        Mockito.verify(this.studentServiceImpl).save("username", "password", name, "surname");
    }

    @Test
    public void testNullSurname() {
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save("username", "password", "name", null));
        Mockito.verify(this.studentServiceImpl).save("username", "password", "name", null);
    }

    @Test
    public void testEmptySurname() {
        String surname = "";
        Assert.assertThrows("InvalidArgumentException expected",
                IllegalArgumentException.class,
                () -> this.studentServiceImpl.save("username", "password", "name", surname));
        Mockito.verify(this.studentServiceImpl).save("username", "password", "name", surname);
    }




}
