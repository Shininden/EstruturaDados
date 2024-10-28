package EstruturaDados.Pilhas;

public class Livro 
{
    String name;
    String publicationYear;
    String author;

    public Livro(String name, String pubYear, String author) 
    {
        super();
       this.name = name;
       this.publicationYear = pubYear;
       this.author = author;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
	public String toString() 
    {
		return "Livro [autor = " + author + ", anoLancamento = " + publicationYear + ", nome = " + name + "]";
	}
}