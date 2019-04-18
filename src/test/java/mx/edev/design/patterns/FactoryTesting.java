package mx.edev.design.patterns;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.creational.factory.Website;
import mx.edev.design.patterns.creational.factory.WebsiteFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryTesting {

    @Test
    public void evaluate() {
        Website site = WebsiteFactory.getWebsite("blog");

        assertNotNull("Site is null!!!", site);
        System.out.println(site);

        Website newSite = WebsiteFactory.getWebsite("shop");

        assertNotNull("New site is null!!!", newSite);
        System.out.println(site);

        assertNotEquals("Sites are equal... no way!", site, newSite);

    }
}