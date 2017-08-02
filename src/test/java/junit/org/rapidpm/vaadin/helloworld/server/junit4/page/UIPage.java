package junit.org.rapidpm.vaadin.helloworld.server.junit4.page;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;

import org.openqa.selenium.support.FindBy;
import org.rapidpm.vaadin.helloworld.server.MyUI;

import com.github.webdriverextensions.WebPage;

public class UIPage extends WebPage {

	@FindBy(id = MyUI.CALC_A_ID)
	private CaluclatorComponent calucaltorA;

	@FindBy(id = MyUI.CALC_B_ID)
	private CaluclatorComponent calucaltorB;

	@Override
	public void assertIsOpen(Object... arg0) throws AssertionError {
		assertIsDisplayed(calucaltorA);
		assertIsDisplayed(calucaltorB);
	}

	@Override
	public void open(Object... arg0) {
		open("http://localhost:8080");
		assertIsOpen();
	}

	public CaluclatorComponent getCalucaltorA() {
		return calucaltorA;
	}

	public CaluclatorComponent getCalucaltorB() {
		return calucaltorB;
	}
}
