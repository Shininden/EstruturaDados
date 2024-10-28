package EstruturaDados.Filas;

public class Paciente implements Comparable<Paciente>
{
    String nome;
    int priority;

    public Paciente(String nome, int priority)
    {
        super();
        this.nome = nome;
        this.priority = priority;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return " Paciente: {" +
                "nome: '" + nome + '\'' +
                ", priority: " + priority +
                "} ";
    }

    @Override
    public int compareTo(Paciente obj)
    {
        if(getPriority() > obj.getPriority()) {
            return 1;
        }
        else if(getPriority() < obj.getPriority()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
