import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import catolica.sistema.dominio.EstadoPedido;
import catolica.sistema.dominio.Pedido;
import catolica.sistema.fachada.FachadaProcessamentoPedidosMock;

//-----------------------------------------------------------------------------------------
/** Classe que implementa os testes unitários do sistema de processamento de pedidos */
//-----------------------------------------------------------------------------------------
class TesteProcessamentoPedidos {

	//-------------------------------------------------------------
	/** Regra: o valor de um pedido não pode ser menor que zero */
	//-------------------------------------------------------------
	@Test
	void teste_1() {
		Pedido pedido = new Pedido() ;
		pedido.setValorPedido(50.00);
		assertTrue(pedido.getValorPedido() >= 0, "O valor de um pedido não pode ser menor que zero.");
	}

	//-------------------------------------------------------------
	/** Regra: o valor de um pedido não pode ser menor que zero */
	//-------------------------------------------------------------
	@Test
	void teste_2() {
		Pedido pedido = new Pedido() ;
		pedido.setValorPedido(0.00);
		assertTrue(pedido.getValorPedido() >= 0, "O valor de um pedido não pode ser menor que zero.");		
	}	
	
	//-------------------------------------------------------------
	/** Regra: o valor de um pedido não pode ser menor que zero */
	//-------------------------------------------------------------
	@Test
	void teste_3() {
		Pedido pedido = new Pedido() ;
		pedido.setValorPedido(-50.00);
		assertTrue(pedido.getValorPedido() >= 0, "O valor de um pedido não pode ser menor que zero.");	
	}
	
	
	
	
	
	
	
	//-----------------------------------------------------------------------------------
	/** Regra: quando um pedido é registrado ele recebe um id e o estado de 'criado'. 
	 *  Regra: quando o pedido já tem um id ou estado ele não pode ser registrado */
	//-----------------------------------------------------------------------------------
	@Test
	void teste_4() {
		Pedido pedido = new Pedido() ;
		pedido.setValorPedido(50.00);
		getFachada().registrarPedido(pedido) ;
		assertTrue(pedido.getId() != null && EstadoPedido.CRIADO.equals(pedido.getEstadoPedido()), "O pedido não foi registrado com sucesso.");	
	}
	
	//-----------------------------------------------------------------------------------
	/** Regra: quando um pedido é registrado ele recebe um id e o estado de 'criado'. 
	 *  Regra: quando o pedido já tem um id ou estado ele não pode ser registrado */
	//-----------------------------------------------------------------------------------
	@Test
	void teste_5() {
		Pedido pedido = new Pedido() ;
		pedido.setId(1);
		pedido.setValorPedido(50.00);		
		getFachada().registrarPedido(pedido) ;
		assertTrue(pedido.getId() != null && EstadoPedido.CRIADO.equals(pedido.getEstadoPedido()), "O pedido não foi registrado com sucesso.");
	}		
	
	//-----------------------------------------------------------------------------------
	/** Regra: quando um pedido é registrado ele recebe um id e o estado de 'criado'. 
	 *  Regra: quando o pedido já tem um id ou estado ele não pode ser registrado */
	//-----------------------------------------------------------------------------------
	@Test
	void teste_6() {
		Pedido pedido = new Pedido() ;
		pedido.setValorPedido(50.00);
		pedido.setEstadoPedido(EstadoPedido.PROCESSADO);
		getFachada().registrarPedido(pedido) ;
		assertTrue(pedido.getId() != null && EstadoPedido.CRIADO.equals(pedido.getEstadoPedido()), "O pedido não foi registrado com sucesso.");	
	}			
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------------------
	/** Regra: quando um pedido é processado ele passa para o estado 'processado'. 
	 *  Regra: Para ser processado o pedido deve estar no estado 'criado' ou 'alterado' */
	//--------------------------------------------------------------------------------------
	@Test
	void teste_7() {
		Pedido pedido = new Pedido() ;
		pedido.setId(1);
		pedido.setEstadoPedido(EstadoPedido.CRIADO);
		getFachada().processarPedido(pedido) ;
		assertTrue(EstadoPedido.PROCESSADO.equals(pedido.getEstadoPedido()), "Para ser processado o pedido deve estar no estado 'criado' ou 'alterado'.");	
	}	

	//-------------------------------------------------------------------------------------
	/** Regra: quando um pedido é processado ele passa para o estado 'processado'. 
	 *  Regra: Para ser processado o pedido deve estar no estado 'criado' ou 'alterado' */
	//--------------------------------------------------------------------------------------
	@Test
	void teste_8() {
		Pedido pedido = new Pedido() ;
		pedido.setId(1);
		pedido.setEstadoPedido(EstadoPedido.ALTERADO);
		getFachada().processarPedido(pedido) ;
		assertTrue(EstadoPedido.PROCESSADO.equals(pedido.getEstadoPedido()), "Para ser processado o pedido deve estar no estado 'criado' ou 'alterado'.");	
	}		
	
	//-------------------------------------------------------------------------------------
	/** Regra: quando um pedido é processado ele passa para o estado 'processado'. 
	 *  Regra: Para ser processado o pedido deve estar no estado 'criado' ou 'alterado' */
	//--------------------------------------------------------------------------------------
	@Test
	void teste_9() {
		Pedido pedido = new Pedido() ;
		pedido.setId(1);
		pedido.setEstadoPedido(EstadoPedido.ALTERADO);
		getFachada().processarPedido(pedido) ;
		assertFalse(EstadoPedido.PROCESSADO.equals(pedido.getEstadoPedido()), "Para ser processado o pedido deve estar no estado 'criado' ou 'alterado'.");	
	}		
	
	
	/** Retorna uma instancia da fachada responsavel pelo processamento de pedidos */
	public FachadaProcessamentoPedidosMock getFachada() {
		return new FachadaProcessamentoPedidosMock() ;
	}

}
