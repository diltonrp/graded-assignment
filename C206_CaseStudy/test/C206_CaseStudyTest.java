import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Student sd1;
	private Student sd2;
	private Student sd3;
	private teacher tc1;
	private teacher tc2;
	private teacher tc3;
	private CCA cc1;
	private CCA cc2;
	private CCA cc3;
	private CCA cc4;
	private CCA cc5;
	
	private ArrayList<Student> studentList;
	private ArrayList<teacher> teacherList;
	private ArrayList<CCA> ccaList;
	

	
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
