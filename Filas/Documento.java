package EstruturaDados.Filas;

public class Documento
{
    private String name;
    private int pages;

    public Documento(String name, int pages)
    {
        this.setName(name);
        this.setPages(pages);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
