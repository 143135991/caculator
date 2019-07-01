import org.junit.*;

import org.junit.Assert;

public class caculatorTest {

    caculator cacu;

    @Test
    public void caculate() {
        cacu = new caculator();
        double result = cacu.caculate(1.38,2.36,1);
        Assert.assertEquals("加法有问题", 3.74, result);
        result = cacu.caculate(1.36,2.38,2);
        Assert.assertEquals("减法有问题", -1.02, result);
        result = cacu.caculate(3.0,2.0,3);
        Assert.assertEquals("乘法有问题", 6.0, result);
        result = cacu.caculate(3.0,2.0,4);
        Assert.assertEquals("除法有问题", 1.5, result);
        result = cacu.caculate(3.0,0,4);
        Assert.assertEquals("除法有问题", 0, result);
    }

}