package org.iftm.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvaliadorTest {
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Usuario pedro;
	private Leilao leilao;
	private Avaliador avaliador;

	@BeforeEach
	public void instanciarObjetos() {
		joao = new Usuario("João");
		jose = new Usuario("Jose");
		maria = new Usuario("Maria");
		pedro = new Usuario("Pedro");

		leilao = new Leilao("Plastaytion 3 novo");
		avaliador = new Avaliador();
	}

	@Test
	public void testarMenorLanceSemOrdem() {

		// Criar lances
		leilao.propoe(new Lance(pedro, 100.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = 100.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMenorLance(), 0.0001);

	}

	@Test
	public void testarMaiorLanceSemOrdem() {

		// Criar
		leilao.propoe(new Lance(pedro, 100.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void testarMenorLanceComOrdemCrescente() {

		// Criar lances

		leilao.propoe(new Lance(pedro, 100.0));
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = 100.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceComOrdemCrescente() {

		// Criar lances
		leilao.propoe(new Lance(pedro, 100.0));
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);

	}

	@Test
	public void testarMenorLanceComOrdemDecrescente() {

		// Criar lances

		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(pedro, 100.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = 100.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceComOrdemDecrescente() {

		// Criar lances
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(pedro, 100.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações entre pontos

		Double valorEsperado = 400.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);

	}

	@Test
	public void testarMenorLanceComUmLance() {

		// Criar lances

		leilao.propoe(new Lance(pedro, 100.0));

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = 100.0;
		Assertions.assertEquals(valorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceSemLance() {

		// Criar lances

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = Double.NEGATIVE_INFINITY;
		Assertions.assertEquals(valorEsperado, avaliador.getMaiorLance(), 0.0001);

	}

	@Test
	public void testarMenorLanceSemLance() {

		// Criar lances

		// Execução
		avaliador.avalia(leilao);

		// Comparações

		Double valorEsperado = Double.POSITIVE_INFINITY;
		Assertions.assertEquals(valorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarTresMaioresLancesOrdemCrescente() {
		
		leilao.propoe(new Lance(pedro,100.0));
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		avaliador.avalia(leilao);
		List<Lance> maiores = avaliador.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(250, maiores.get(2).getValor(), 0.00001);
	}

	@Test
	public void nãoDeveAvaliarLeiloesSemNenhumLanceDado(){
		try{
			avaliador.avalia(leilao);
			
		}catch (Exception e) {
			// tudo ok;
	    
		}
		
	}

}
