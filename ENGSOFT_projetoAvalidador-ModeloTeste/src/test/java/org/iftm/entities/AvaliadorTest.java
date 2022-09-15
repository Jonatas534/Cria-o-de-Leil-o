package org.iftm.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvaliadorTest {
	private Usuario  joao;
	private Usuario jose;
	private Usuario  maria;
	private Leilao leilao;
	private Avaliador avaliador;
	
	@BeforeEach
	public void instanciarObjetos() {
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Plastaytion 3 novo");
		Avaliador avaliador = new Avaliador();
	}
	@Test
	public void testarMenorLanceSemOrdem() {
		
		
		//Criar lances
		
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 250.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMenorLance(),0.0001);
			
	}
	
	@Test
	public void testarMaiorLanceSemOrdem() {

		
		//Criar
		
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMaiorLance(),0.0001);
	}		
			

	@Test
	public void testarMenorLanceComOrdemCrescente() {
		
		
		//Criar lances
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
	
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 250.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMenorLance(),0.0001);
	}
	
	

	
	@Test
	public void testarMaiorLanceComOrdemCrescente() {
	
		
		//Criar lances
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMaiorLance(),0.0001);
			
	}
	
	@Test
	public void testarMenorLanceComOrdemDecrescente() {
	
		
		//Criar lances
		
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));
	
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 250.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMenorLance(),0.0001);
	}
	
	

	
	@Test
	public void testarMaiorLanceComOrdemDecrescente() {
		
		
		//Criar lances
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));
		
		
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações entre pontos
		
		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMaiorLance(),0.0001);
			
	}
	
	@Test
	public void testarMenorLanceComUmLance() {
		
		
		//Criar lances
		
		
		leilao.propoe(new Lance(maria, 250.0));
	
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 250.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMenorLance(),0.0001);
	}
	
	@Test
	public void testarMaiorLanceSemLance() {
		
		
		//Criar lances
		
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMaiorLance(),0.0001);
			
	}
	
	@Test
	public void testarMenorLanceSemLance() {
	
		
		//Criar lances
		
		
	
		
		
		//Execução
		avaliador.avalia(leilao);
		
		//Comparações
		
		Double valorEsperado = 250.0;
		Assertions.assertEquals(valorEsperado,avaliador.getMenorLance(),0.0001);
	}
	
	
}
