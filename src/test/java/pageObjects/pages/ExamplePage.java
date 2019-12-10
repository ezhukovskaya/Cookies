package pageObjects.pages;

import framework.base.BaseForm;
import framework.browser.Browser;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class ExamplePage extends BaseForm {
    private static Label exampleLabel = new Label(By.xpath("//h1[contains(text(),'Example Domain')]"),"Example Domain");

    public ExamplePage() {
        super(exampleLabel);
    }

    public void addCookie(Cookie cookie){
        Browser.addCookie(cookie);
    }

    public Set<Cookie> getCookies(){
        return Browser.getCookies();
    }
}
