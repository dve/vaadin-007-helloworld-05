package junit.org.rapidpm.vaadin.helloworld.server.junit4;

import static com.github.webdriverextensions.Bot.assertAttributeEquals;
import static com.github.webdriverextensions.Bot.open;
import static com.github.webdriverextensions.Bot.type;
import static com.github.webdriverextensions.vaadin.VaadinBot.clickAndWait;

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
		type("5", uiPage.getCalucaltorA().getInputA());
		type("5", uiPage.getCalucaltorA().getInputB());

		clickAndWait(uiPage.getCalucaltorA().getButton());

		assertAttributeEquals("value", 10, uiPage.getCalucaltorA().getOutput());

		assertAttributeEquals("value", "", uiPage.getCalucaltorB().getOutput());
	}

	@Test
	public void test002() throws Exception {

		open(uiPage);
		type("Hello, ", uiPage.getCalucaltorB().getInputA());
		type("World!", uiPage.getCalucaltorB().getInputB());

		clickAndWait(uiPage.getCalucaltorB().getButton());

		assertAttributeEquals("value", "Hello, World!", uiPage.getCalucaltorB().getOutput());
		assertAttributeEquals("value", "", uiPage.getCalucaltorA().getOutput());
	}
}
