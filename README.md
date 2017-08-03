# vaadin-007-helloworld-05

Here we are switching to [webdriver extensions](http://webdriverextensions.github.io/).

This example shows us, how to deal with failed tests and screenshots.

Webdriver extensions will download the driver for our operating system. It will also help us
organizing our test code into page objects and reusable components.

The `VaadinBot` class helps us to wait until the vaadin framework is finished rendering the page in the browser.

If you want to run the tests on a remote system set the system property `webdriverextensions.remoteaddress` e.g.:

```
mvn install -Dwebdriverextensions.remoteaddres=http://selenium-standalone-chrome:4444/wd/hub
```
