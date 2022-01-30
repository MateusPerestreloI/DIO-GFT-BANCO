import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Conta> contas = new ArrayList<Conta>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		};
		Banco sustenido = new Banco();
		
		Cliente fernando = new Cliente();
		fernando.setNome("Fernando");
		
		Cliente luiza = new Cliente();
		luiza.setNome("Luiza");
		
		Conta cc = new ContaCorrente(fernando);
		Conta cp = new ContaPoupanca(luiza);
		Conta cc2 = new ContaCorrente(luiza);
		sustenido.setNome("Sustenido");
		sustenido.adicionarConta(cc);
		sustenido.adicionarConta(cp);
		sustenido.adicionarConta(cc2);

		System.out.println("---------------- Deposito --------------------\n");
		cc.depositar(100);

		System.out.println("---------------- Extratos --------------------\n");
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();
		cc2.imprimirExtrato();

		System.out.println("---------------- Transferencia --------------------\n");
		cc.transferir(75, cp);

		System.out.println("---------------- Extratos --------------------\n");
		cc.imprimirExtrato();
		cp.imprimirExtrato();
		cc2.imprimirExtrato();

		System.out.println("---------------- Clientes do Banco --------------------\n");
		
		sustenido.imprimirClientes();
	}

}
