package EstruturaDados.Pilhas;

public class Contato 
{
	private String name;
	private String phone;
	private String email;
	
	public Contato(String nome, String telefone, String email) 
    {
		super();
		this.name = nome;
		this.phone = telefone;
		this.email = email;
	}

	public Contato() {}
	
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String telefone) {
		this.phone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato (nome: " + name + ", telefone: " + phone + ", email: "+ email + ")";
	}

	@Override
	public int hashCode() 
    {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
    {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Contato other = (Contato) obj;
		if (email == null) 
        {
			if (other.email != null) {
				return false;
			}
		} 
        else if (!email.equals(other.email)) {
			return false;
		}

		if (name == null) 
        {
			if (other.name != null) {
				return false;
			}
		} 
        else if (!name.equals(other.name)) {
			return false;
		}

		if (phone == null) 
        {
			if (other.phone != null) {
				return false;
			}
		} 
        else if (!phone.equals(other.phone)) {
			return false;
		}
		return true;
	}
}