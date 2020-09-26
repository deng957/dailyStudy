import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class test {
    public static void main(String args[]){
        ComicBook dragonBall = new ComicBook();
        dragonBall.setAuthor("鸟山明");
        dragonBall.setBookName("七龙珠");
        dragonBall.setStyle("战斗");
        String message = MessageFormat.format("这本书名是{0}，作者是{1}，是{2}漫画",dragonBall.getBookName(),dragonBall.getAuthor(),dragonBall.getStyle());
        System.out.println(message);
    }
}
