package br.com.javaparaweb.capitulo12.jfreechart;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import javax.faces.bean.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.*;

@ManagedBean
@RequestScoped
public class CidadeColunasBean {

	private StreamedContent			grafico;
	private static final Logger	log	= Logger.getLogger(CidadeColunasBean.class.getName());

	public CidadeColunasBean() {
		try {
			JFreeChart graficoColunas = ChartFactory.createBarChart("5 cidades mais populosas de SC",
				"Cidades", "População", this.geraDados(), PlotOrientation.VERTICAL, false, true, false); //1*
			File arquivoGrafico = new File("colunas.png");
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoColunas, 500, 325);
			this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png");
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}

	private DefaultCategoryDataset geraDados() { //*2
		DefaultCategoryDataset dts = new DefaultCategoryDataset();
		dts.setValue(new Double(334002.0), "População", "Blumenau");
		dts.setValue(new Double(204667.0), "População", "Criciúma");		
		dts.setValue(new Double(461524.0), "População", "Florianopólis");
		dts.setValue(new Double(554601.0), "População", "Joinville");
		dts.setValue(new Double(228561.0), "População", "São José");	
		return dts;
	}
	public StreamedContent getGrafico() {
		return this.grafico;
	}
}


/* 1 - Estamos gerando um grafico de colunas : veja a chamada para a classe ChartFactory.createBartChart.Ali são passados
 * como parâmetros nome e grafico, o titulo do exo X, o titulo do eixo Y,a fonte de dados, o eixo que será o eixo vertical,
 * no caso, o eixo Y,se há legenda, se há informaçoês (tips) e a ausência de URLs vinculadas.
 * 
 * 2 - Geramos as informações necessarias. foi preciso informar três dados: o valor de cada coluna,o valor para as linhas
 * do grafico e o valor para as colunas do gráfico.Observe também que trabalhamos com outra classe(DefaltCategoryDataset)
 * para armazenar os dados, ja que agora o tipo de grafico mudou.
 * 
 * 
 */
