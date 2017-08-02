package org.rapidpm.vaadin.helloworld.server;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
public class MyUI extends UI {

	public static final String CALC_B_ID = "calc-B";
	public static final String CALC_A_ID = "calc-A";

	@Override
	protected void init(VaadinRequest request) {

		Calculator calculatorA = new Calculator();
		calculatorA.setId(CALC_A_ID);
		Calculator calculatorB = new Calculator();
		calculatorB.setId(CALC_B_ID);

		setContent(new VerticalLayout(calculatorA, calculatorB));
	}
}
