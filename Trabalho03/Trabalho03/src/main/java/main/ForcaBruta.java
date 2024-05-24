package main;

import java.util.ArrayList;

public class ForcaBruta {
	private Solucao solucao;

	public ForcaBruta() {}
	
	public Solucao solucao(Problema problema, Solucao solucaoInicial) 
    {
		setSolucao(solucaoInicial);
		ArrayList<Integer> caminhoInicial = new ArrayList<>();
		caminhoInicial.add(0);
		Solucao subSolucao = new Solucao(caminhoInicial, 0);
		algoritmoForcaBruta(problema, subSolucao);
		return solucao;
	}
    
	public void algoritmoForcaBruta(Problema problema, Solucao subSolucao) 
    {
		if(subSolucao.getTamanhoCaminho() == problema.getNumeroDeCidades()) {
			subSolucao.incrementarDistancia(problema.getDistancia(subSolucao.getUltimaCidade(), 0));
			if(subSolucao.getDistanciaMinima() < solucao.getDistanciaMinima()) {
				subSolucao.addCidadeNoCaminho(0);
				setSolucao(subSolucao);
			}
		}else {
			for(int i = 0; i < problema.getNumeroDeCidades(); i++) {
				if(!subSolucao.getCaminho().contains(i)) {
					int increasedDistance = subSolucao.getDistanciaMinima() + problema.getDistancia(subSolucao.getUltimaCidade(), i);
					ArrayList<Integer> incrementarCaminho = (ArrayList<Integer>) subSolucao.getCaminho().clone();
					incrementarCaminho.add(i);
					Solucao incrementarSolucao = new Solucao(incrementarCaminho, increasedDistance);
					algoritmoForcaBruta(problema, incrementarSolucao);
				}
			}
		}
	}
	
    /**
	 * @param solucaoAtual the solucaoAtual to set
	 */
	
     public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}
	
}