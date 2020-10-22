import org.apache.commons.lang3.reflect.FieldUtils;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.MessageFormat;

public class Reflect {
    public static void main(String args[]) throws IllegalAccessException{
        Book book =new Book();
        book.setAuthor("ABC");
        book.setBookKind("comic");
        book.setBookName("TEST");
        book.setLanguage("English");
        Object bookTset = (Object)book;
        Class bookClass = (Class)bookTset.getClass();
        Field[] fields = bookClass.getDeclaredFields();
        for (Field item:fields){
            Object data = FieldUtils.readField(item,bookTset,true);
            String msg = MessageFormat.format("变量名为{0}，值为{1}",item.getName(),data);
            System.out.println(msg);
        }
    }

}
