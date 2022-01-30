import lombok.Getter;
import lombok.Setter;

public abstract class Conta implements IConta{
 
	private final static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	@Getter
	@Setter
	protected int agencia;
	@Getter
	@Setter
	protected int numero;
	@Getter
	@Setter
	protected double saldo;
	@Getter
	@Setter
	protected Cliente cliente;

	public Conta(Cliente cliente)
	{
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = Conta.SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	@Override
	public void sacar(double valor) {
		// TODO Auto-generated method stub
		System.out.println(String.format("O valor de R$%.2f foi sacado na conta Nº %d \n", valor, this.numero));
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		// TODO Auto-generated method stub
		System.out.println(String.format("O valor de R$%.2f foi depositado na conta Nº %d \n", valor, this.numero));
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		// TODO Auto-generated method stub
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.println(String.format("O valor de R$%.2f foi transferido da conta Nº %d para a conta Nº %d \n", valor, this.numero, contaDestino.getNumero()));
	}

	protected void imprimirDadosConta() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f \n", this.saldo));
	}
}
