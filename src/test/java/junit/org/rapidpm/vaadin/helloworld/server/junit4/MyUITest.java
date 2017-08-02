package junit.org.rapidpm.vaadin.helloworld.server.junit4;

import static com.github.webdriverextensions.Bot.assertAttributeEquals;
import static com.github.webdriverextensions.Bot.click;
import static com.github.webdriverextensions.Bot.open;
import static com.github.webdriverextensions.Bot.type;

import org.junit.Test;

import junit.org.rapidpm.vaadin.helloworld.server.junit4.base.BaseSeleniumTest;
import junit.org.rapidpm.vaadin.helloworld.server.junit4.page.UIPage;

/**
 *
 */

public class MyUITest extends BaseSeleniumTest {

	private UIPage uiPage;

	@Test
	public void test001() throws Exception {

		open(uiPage);
		type("5", uiPage.getInputA());
		type("5", uiPage.getInputB());

		click(uiPage.getButton());

		assertAttributeEquals("value", 10, uiPage.getOutput());
	}

	@Test
	public void test002() throws Exception {

		open(uiPage);
		type("Hello, ", uiPage.getInputA());
		type("World!", uiPage.getInputB());

		click(uiPage.getButton());

		assertAttributeEquals("value", "Hello, World!", uiPage.getOutput());
	}
}
