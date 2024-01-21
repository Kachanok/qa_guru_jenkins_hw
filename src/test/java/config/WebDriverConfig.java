package config;

import org.aeonbits.owner.Config;

import java.net.URL;


@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String baseUrl();


    @Key("browser")
    @DefaultValue("CHROME")
    String browser();


    @Key("browserVersion")
    @DefaultValue("100")
    String browserVersion();


    @Key("browserSize")
    @DefaultValue("1280x1024")
    String browserSize();


    @Key("isRemote")
    @DefaultValue("true")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    URL remoteUrl();


}