import com.google.dao.BookDao;
import com.google.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lenny
 * @Date: 2022/7/24 03:34
 * @Description:
 */
public class ScopeTest {

    /**
     * 验证Spring的单例模式
     * <p>
     * 1.xml不加scope(或者scope="")
     */
    @Test
    public void Demo1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService1 = (BookService) ctx.getBean("lenny");
        BookService bookService2 = (BookService) ctx.getBean("lenny");

        //System.out.println(bookService1);
        //System.out.println(bookService2);

        // 判断是否是同一个对象
        // 打印hashcode
        System.out.println(bookService1.hashCode());
        System.out.println(bookService2.hashCode());
    }

    /**
     * 2.xml scope为prototype.非单例模式
     */
    @Test
    public void Demo2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");

        System.out.println(bookDao1.hashCode());
        System.out.println(bookDao2.hashCode());

        System.out.println(bookDao1.equals(bookDao2));
    }
}
