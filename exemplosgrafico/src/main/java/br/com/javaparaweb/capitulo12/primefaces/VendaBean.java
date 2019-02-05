package br.com.javaparaweb.capitulo12.primefaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped; 
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "vendaBean") //1*
@RequestScoped //2*
public class VendaBean {
	private PieChartModel vendaPais;

	public VendaBean() { //3*
		this.vendaPais = new PieChartModel();
		this.vendaPais.set("Brasil", 540.50f);
		this.vendaPais.set("Estados Unidos", 590.52f);
		this.vendaPais.set("Inglaterra", 475.30f);
		this.vendaPais.set("França", 400);
		this.vendaPais.set("Alemanha", 397.33f);
		this.vendaPais.setTitle("Gráfico de vendas por país");
		this.vendaPais.setLegendPosition("e");
		this.vendaPais.setShowDataLabels(true);
		this.vendaPais.setDataFormat("percent");
	}

	public PieChartModel getVendaPais() {
		return vendaPais;
	}
}

/*
 * 1 - Mapeamos nossa classe com a notação do JSF 2, em que o apelido (alias) de nossa classe passa a ser vendaBean,sendo 
 * este o nome referenciado em nossa pagina.
 * 
 * 2 - Mapeamos o escopo de requisição, que, no caso, é do tipo @RequestScoped.
 * 
 * 3 - No construtor da classe foram criados os dados com as informações dos paises que podem ser adicionados diretamente 
 * aos gráfico. As informações em seguida referem-se às configurações do grafico, como titulo,posição da legenda,se os
 * valores aparecerão nas fatias da pizza e etc.
 * 
 */