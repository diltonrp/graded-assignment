import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Student sd1;
	private Student sd2;
	private Student sd3;
	private Teacher tc1;
	private Teacher tc2;
	private Teacher tc3;
	private CCA cc1;
	private CCA cc2;
	private CCA cc3;
	private CCA cc4;
	private CCA cc5;
	
	private ArrayList<Student> studentList;
	private ArrayList<Teacher> teacherList;
	private ArrayList<CCA> ccaList;
	

	@Before
	public void setUp() throws Exception {
		sd1 = new Student(21000000, "T0123456A", "Mark", "mark@gmail.com", 88888888, "DIT", "W67N", "");
		sd2 = new Student(21000001, "T0184637B", "Jack", "jack@gmail.com", 88888887, "DIT", "W67N", "");
		sd3 = new Student(21000002, "T0128475C", "Mary", "mary@gmail.com", 88888886, "DIT", "W67N", "");
		tc1 = new Teacher(123, "Dilton", "Republ!c01", "dilton@gmail.com", 99999999);
		tc2 = new Teacher(124, "Yong Jian", "Republ!c01", "yongjian@gmail.com", 99999998);
		tc3 = new Teacher(125, "Robert", "Republ!c01", "lela@gmail.com", 99999997);
		cc1 = new CCA(1, "Badminton", "Able to play badminton and have fun!", "15:00", "Monday", "Sports");
		cc2 = new CCA(2, "Red Cross", "Save people when they are in need!", "16:00", "Friday", "Uniform Groups");
		cc3 = new CCA(3, "Chorale", "Sing on stage!", "16:00", "Monday", "Performing Arts");
		cc4 = new CCA(4, "Basketball", "Play basketball!", "15:00", "Monday", "Sports");
		cc5 = new CCA(5, "Orchestra", "Play your desired instrument", "15:30", "Wednesday", "Performing Arts");
	}
	
	@Test
	public void testAddStudent() {
		
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);
		
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
