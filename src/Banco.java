import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Banco {
	
	@Getter
	@Setter
	private String nome;
	@Getter
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void imprimirClientes() 
	{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for(Conta conta: contas)
		{
			if(!clientes.contains(conta.getCliente()))
			{
				clientes.add(conta.getCliente());
			}
		}
		for(Cliente cliente : clientes)
		{
			System.out.println("Nome: " + cliente.getNome());
		}
	}
	
	public void adicionarConta(Conta conta)
	{
		this.contas.add(conta);
	}
}
