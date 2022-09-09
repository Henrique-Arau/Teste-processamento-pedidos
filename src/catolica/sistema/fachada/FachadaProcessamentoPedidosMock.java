package catolica.sistema.fachada;

import catolica.sistema.dominio.EstadoPedido;
import catolica.sistema.dominio.Pedido;

//-------------------------------------------------------------------------------
/** Fachada que contem as operacoes necessárias para tratamento de pedidos */
//-------------------------------------------------------------------------------
public class FachadaProcessamentoPedidosMock {
	
	//--------------------------------------------------------------------------------------------------
	/** Método auxiliar. A partir de um numero aleatorio, decide se a operacao deve falhar ou não */
	//--------------------------------------------------------------------------------------------------
	private boolean operacaoDeveFalhar() {
		int numAleatorio = (int) (Math.random() * 100) ;
		return (numAleatorio % 2) == 0 ;
	}
	
	//private boolean operacaoDeveFalhar() {
	//	return false ;
	//}
		
	//--------------------------------------------------------
	/** Registro de um pedido. */
	//--------------------------------------------------------
	public void registrarPedido(Pedido pedido) {
		// Regra: Para o pedido ser registrado ele não pode ter um identificador
		if(pedido.getId() != null) {
			throw new RuntimeException("O pedido informado já tem um id, e por isso não pode ser registrado.") ;
		}
		
		// Regra: Para o pedido ser registrado ele não pode ter um estado
		if(pedido.getEstadoPedido() != null) {
			throw new RuntimeException("O pedido já tem um estado, e por isso não pode ser registrado.") ;
		}
		
		// Passo adicional: verifica se o banco de dados está fora do ar (operacao falhou) 
		if(operacaoDeveFalhar()) {
			throw new RuntimeException("O banco de dados do sistema de registro de pedidos está fora do ar.") ;
		} 
		
		// Se as regras para registro do pedido foram satisfeitas, salva no banco de dados
		pedido.setId((int)Math.random()*10000);
		pedido.setEstadoPedido(EstadoPedido.CRIADO);
	}
	
	//--------------------------------------------------------
	/** Processamento de um pedido.  */
	//--------------------------------------------------------
	public void processarPedido(Pedido pedido) {
		// Regra: Para o pedido ser processado ele deve estar no estado 'criado' ou 'alterado'
		if(!EstadoPedido.CRIADO.equals(pedido.getEstadoPedido()) &&
				!EstadoPedido.ALTERADO.equals(pedido.getEstadoPedido())) {
			throw new RuntimeException("O pedido deve estar no estado 'criado' ou 'alterado' para ser processado.") ;
		}
		
		// Passo adicional: verifica se o banco de dados está fora do ar (operacao falhou)
		if(operacaoDeveFalhar()) {
			throw new RuntimeException("O banco de dados do sistema de registro de pedidos está fora do ar.") ;
		} 
		
		// Se as regras para processamento do pedido foram satisfeitas, salva no banco de dados
		pedido.setEstadoPedido(EstadoPedido.PROCESSADO);
	}
	
}
