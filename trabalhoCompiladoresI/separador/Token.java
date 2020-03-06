package separador;

public class Token {
	public String texto;
	public EnumClassToken enumeracao;

	public Token() {
	}
	
	public Token(String t, EnumClassToken e) {
		setTexto(t);
		setEnumeracao(e);
	}
	
	@Override
	public String toString() {
		return getTexto()+", "+getEnumeracao();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public EnumClassToken getEnumeracao() {
		return enumeracao;
	}

	public void setEnumeracao(EnumClassToken enumeracao) {
		this.enumeracao = enumeracao;
	}
}
