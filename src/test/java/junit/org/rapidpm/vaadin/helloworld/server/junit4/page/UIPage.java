package junit.org.rapidpm.vaadin.helloworld.server.junit4.page;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static org.rapidpm.vaadin.helloworld.server.Calculator.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.Calculator.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.Calculator.INPUT_ID_B;
import static org.rapidpm.vaadin.helloworld.server.Calculator.OUTPUT_ID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.webdriverextensions.WebPage;

public class UIPage extends WebPage {

	@FindBy(id = BUTTON_ID)
	private WebElement button;
	@FindBy(id = INPUT_ID_A)
	private WebElement inputA;
	@FindBy(id = INPUT_ID_B)
	private WebElement inputB;
	@FindBy(id = OUTPUT_ID)
	private WebElement output;

	@Override
	public void assertIsOpen(Object... arg0) throws AssertionError {
		assertIsDisplayed(inputA);
		assertIsDisplayed(inputB);
		assertIsDisplayed(button);
		assertIsDisplayed(output);
	}

	@Override
	public void open(Object... arg0) {
		open("http://localhost:8080");
		assertIsOpen();
	}

	public WebElement getButton() {
		return button;
	}

	public WebElement getInputA() {
		return inputA;
	}

	public WebElement getInputB() {
		return inputB;
	}

	public WebElement getOutput() {
		return output;
	}

}
