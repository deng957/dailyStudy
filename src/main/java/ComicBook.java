public class ComicBook extends Book {
    private String style;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "ComicBook{" +
                "style='" + style + '\'' +
                '}';
    }
}
