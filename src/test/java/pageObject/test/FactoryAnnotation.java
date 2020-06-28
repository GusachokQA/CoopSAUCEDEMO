package pageObject.test;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryAnnotation {

    @Factory
    @Test
    public Object[] getTestFactoryMethod(){
        Object[] factoryTest = new Object[2];
        factoryTest[0] = new FactorySmoke();
        factoryTest[1] = new FactoryRegression();
        return factoryTest;
    }
}
