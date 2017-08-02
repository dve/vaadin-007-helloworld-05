package org.rapidpm.vaadin.helloworld.server;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class Calculator extends CustomComponent {
	public static final String BUTTON_CLASS = "button";
	public static final String INPUT_A_CLASS = "input-a";
	public static final String INPUT_B_CLASS = "input-b";
	public static final String OUTPUT_CLASS = "output";

	public Calculator() {
		final HorizontalLayout layout = new HorizontalLayout();

		final TextField inputA = new TextField();
		inputA.addStyleName(INPUT_A_CLASS);
		final TextField inputB = new TextField();
		inputB.addStyleName(INPUT_B_CLASS);

		final Button button = new Button("click me");
		button.addStyleName(BUTTON_CLASS);

		final TextField output = new TextField();
		output.setReadOnly(true);
		output.addStyleName(OUTPUT_CLASS);

		layout.addComponents(inputA, new Label("+"), inputB, button, output);

		button.addClickListener(event -> output.setValue(inputA.getValue() + inputB.getValue()));

		setCompositionRoot(layout);
	}
}
