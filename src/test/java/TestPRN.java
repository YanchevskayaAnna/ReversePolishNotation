import org.junit.Assert;
import org.junit.Test;

public class TestPRN {
    @Test
    public void first()  {
        Assert.assertEquals(PolishNotation.reverse("(a+(b*c))"), "abc*+");
    }

    @Test
    public void second()  {
        Assert.assertEquals(PolishNotation.reverse("((a+b)*(z+x))"), "ab+zx+*");
    }

    @Test
    public void third()  {
        Assert.assertEquals(PolishNotation.reverse("((a+t)*((b+(a+c))^(c+d)))"), "at+bac++cd+^*");
    }

    @Test
    public void fourth()  {
        Assert.assertEquals(PolishNotation.reverse("((a+t) *((b+(a+c))^ (c+d)))"), "at+bac++cd+^*");
    }

    @Test
    public void fifth()  {
        Assert.assertEquals(PolishNotation.reverse("((a+t)*((b+(a+c))^(c+d)))999"), "((a+t)*((b+(a+c))^(c+d)))999");
    }

    @Test
    public void sixth()  {
        Assert.assertEquals(PolishNotation.reverse("((a+t)))"), "((a+t)))");
    }

}
