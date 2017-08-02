package junit.org.rapidpm.vaadin.helloworld.server.junit4.page;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static org.rapidpm.vaadin.helloworld.server.Calculator.BUTTON_CLASS;
import static org.rapidpm.vaadin.helloworld.server.Calculator.INPUT_A_CLASS;
import static org.rapidpm.vaadin.helloworld.server.Calculator.INPUT_B_CLASS;
import static org.rapidpm.vaadin.helloworld.server.Calculator.OUTPUT_CLASS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.webdriverextensions.WebPage;

public class UIPage extends WebPage {

	@FindBy(className = BUTTON_CLASS)
	private WebElement button;
	@FindBy(className = INPUT_A_CLASS)
	private WebElement inputA;
	@FindBy(className = INPUT_B_CLASS)
	private WebElement inputB;
	@FindBy(className = OUTPUT_CLASS)
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
