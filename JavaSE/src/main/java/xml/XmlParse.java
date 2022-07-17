package xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析xml
 *
 * @author: lenny
 * @Date: 2022/6/25 13:39
 * @Description:
 */
public class XmlParse {
    public static void main(String[] args) throws DocumentException {
        //1.获取一个解析器对象
        SAXReader saxReader = new SAXReader();

        //2.利用解析器把xml文件加载进内存,返回一个文档对象
        Document document = saxReader.read(new File("JavaSE/src/main/java/xml/student.xml"));

        //3.获取文档的根标签
        Element root = document.getRootElement();

        //4.通过根标签来继续获取子标签
        //element.elements("子标签名称") 获取指定子标签, 会把这些子标签放到集合当中返回;
        //element.elements() 获取所有的子标签, 会把这些子标签放到集合当中返回;
        List<Element> elementList = root.elements("student");

        List<Student> list = new ArrayList<>();

        for (Element element : elementList) {
            // 获取id这个属性
            Attribute attribute = element.attribute("id");
            String idValue = attribute.getValue();

            // 获取name这个标签
            Element nameElement = element.element("name");
            String nameValue = nameElement.getText();

            // 获取age这个标签
            Element ageElement = element.element("age");
            String ageValue = ageElement.getText();

            Student student = new Student(idValue, nameValue, Integer.parseInt(ageValue));

            list.add(student);

        }

        for (Student stu : list) {
            System.out.println(stu);
        }

    }
}
