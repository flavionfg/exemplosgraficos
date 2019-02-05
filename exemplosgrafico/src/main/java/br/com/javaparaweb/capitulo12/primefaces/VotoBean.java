package br.com.javaparaweb.capitulo12.primefaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name="votoBean")
@RequestScoped
public class VotoBean {
	private PieChartModel votos;

	public PieChartModel getVotos() { //1*
		
		int random1 = (int) (Math.random() * 1000);
		int random2 = (int) (Math.random() * 1000);
		int random3 = (int) (Math.random() * 1000);

		this.votos = new PieChartModel();
		this.votos.getData().put("Marca 1", random1);
		this.votos.getData().put("Marca 2", random2);
		this.votos.getData().put("Marca 3", random3);

		this.votos.setTitle("Votos");
		this.votos.setLegendPosition("ne");

		return this.votos;
	}
}


/* 1 - Foi Preciso colocar a regra de negócio da geração dos números da votação nele.Assim para simular o efeito de variação
 * da enquete usamos a calsse Math, a fim de gerar números aleatórios para cada um das opções da enquete.
 */
