
package org.iftm.entities;

import java.util.*;

import com.sun.source.tree.NewArrayTree;

public class Avaliador {

	private List<Lance> maiores;
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	
	
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public double getMenorLance() {
		return menorDeTodos;
		}

	
	
	
	private void pegaOsMaioresNo(Leilao leilao) {

		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
		public int compare(Lance o1, Lance o2) {
		if (o1.getValor() < o2.getValor())

		return 1;

		if (o1.getValor() > o2.getValor())

		return -1;

		return 0;

		}

		});
		maiores = maiores.subList(0, maiores.size()> 3?3 :maiores.size());

		}
		public List<Lance> getTresMaiores() { return this.maiores;}
		
		public void avalia(Leilao leilao) {

			for (Lance lance : leilao.getLances()) {

			if (lance.getValor() > maiorDeTodos) {
			maiorDeTodos = lance.getValor();

			}
			if (lance.getValor() < menorDeTodos) {
			menorDeTodos = lance.getValor();

			}

			}
			pegaOsMaioresNo(leilao);

			}
}

