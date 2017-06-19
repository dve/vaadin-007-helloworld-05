package junit.org.rapidpm.vaadin.helloworld.server.junit4.base;

import org.junit.After;
import org.junit.Before;
import org.rapidpm.vaadin.helloworld.server.Main;

/**
 *
 */
public abstract class BaseTest {

  @Before
  public void setUp() throws Exception {
    Main.start();
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("BaseTest.tearDown !! ");
    Main.shutdown();
  }


}
