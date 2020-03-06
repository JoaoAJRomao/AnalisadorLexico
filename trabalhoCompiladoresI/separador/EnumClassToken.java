package separador;

public enum EnumClassToken {
	SIMBOLO(0), NUMERO(1), OPERADOR(2), IDENTIFICADOR(3), OUT(4);
	public int classeValor;
	EnumClassToken(int valor){
		classeValor=valor;
	}
	public int getClasseValor() {
		return classeValor;
	}
}
