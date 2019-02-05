package br.com.javaparaweb.capitulo12.jfreechart;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import javax.faces.bean.*;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class CidadeBean {
	private StreamedContent	grafico;
	private static final Logger	log	= Logger.getLogger(CidadeBean.class.getName()); //1* 

	public CidadeBean() {
		try {
			JFreeChart graficoPizza = ChartFactory.createPieChart("5 cidades mais populosas de SC", 
				this.geraDados(), true, true, false);  //2*
			File arquivoGrafico = new File("pizza.png"); //3*
			ChartUtilities.saveChartAsPNG(arquivoGrafico, graficoPizza, 500, 300); //4*
			this.grafico = new DefaultStreamedContent(new FileInputStream(arquivoGrafico), "image/png"); //5*
		} catch (Exception e) {
			log.severe(e.getMessage());
		}
	}
	private DefaultPieDataset geraDados() {
		DefaultPieDataset dts = new DefaultPieDataset(); //6*
		dts.setValue("Blumenau", new Double(334002.0));
		dts.setValue("Criciúma", new Double(204667.0));
		dts.setValue("Florianopólis", new Double(461524.0));
		dts.setValue("Joinville", new Double(554601.0));
		dts.setValue("São José", new Double(228561.0));
		return dts;
	}
	public StreamedContent	getGrafico() {
		return this.grafico;
	}
}


/* O grafico da biblioteca JfreeChart é parecido com o do PrimeFaces,mas as configurações são mais faceis,e aqui
 * o grafico é gerado é uma imagem estática.
 * 
 * 1 - Usamos um log para monitorar a geração da imagem do gráfico. Essa propriedade pode ser retirada, mas 
 * é util quando estamos deputando nosso codigo-fonte.
 * 
 * 2 - Variavel graficoPizza que armazena nosso grafico. Com a classe ChartFactory especificamos que gráfico
 * queremos construir, e é a partir dessa classe que montamos os diversos tipos de gráfico. Os parâmetros 
 * passados referem-se ao titulo do grafico,à fonte de dados,à existencia ou não de legenda,informações(tips)
 * e URLs vinculadas.
 * 
 * 3 - Criamos um arquivo para guardar a imagem que será gerada para o grafico.Pode-se especificar um caminho
 * completona qual deverá ser gravada a imagem. Em nosso exemplo,Passamossomente o nome do arquivo Pizza.png
 * mas poderia ser c:\\pizza.png.
 * 
 * 4 - Uma imagem do grafico então é criada usando a classe ChartUtilities e o método saveChartAsPNG. os parametros
 * passados são o nome do arquivo a ser gravado, o gráfico em si,a largura da imagem e a sua altura.
 * 
 * 5 - Geramos o recurso que contém a imagem que deve ser mostrada na página JSF. A classe DefaultStreamedContent 
 * da biblioteca PrimeFaces é responsavel por isso.
 * 
 * 6 - Dentro do método geraDados, temos a construção dos dados necessários ao grafico. A partir da classe 
 * DefaultStreamedContent montamos uma coleção das informações que precisamos.Cada tipo de gráfico tem uma 
 * classe do tipo Dataset especifica.
 * 
 * 
 * *  */
