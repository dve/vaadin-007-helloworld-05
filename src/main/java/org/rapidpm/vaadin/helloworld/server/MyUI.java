package org.rapidpm.vaadin.helloworld.server;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 *
 */
public class MyUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
		setContent(new Calculator());
  }
}
