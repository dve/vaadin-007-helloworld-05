package junit.org.rapidpm.vaadin.helloworld.server.junit4.page;

import static org.rapidpm.vaadin.helloworld.server.Calculator.BUTTON_CLASS;
import static org.rapidpm.vaadin.helloworld.server.Calculator.INPUT_A_CLASS;
import static org.rapidpm.vaadin.helloworld.server.Calculator.INPUT_B_CLASS;
import static org.rapidpm.vaadin.helloworld.server.Calculator.OUTPUT_CLASS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.webdriverextensions.WebComponent;

public class CaluclatorComponent extends WebComponent {

	@FindBy(className = BUTTON_CLASS)
	private WebElement button;
	@FindBy(className = INPUT_A_CLASS)
	private WebElement inputA;
	@FindBy(className = INPUT_B_CLASS)
	private WebElement inputB;
	@FindBy(className = OUTPUT_CLASS)
	private WebElement output;

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
