import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorHTML extends Observador{
    private PedidoObersavel pedido;
    private String nomeArq;
    FileWriter arq;

    public GeradorHTML(PedidoObersavel p) throws IOException {
        this.nomeArq = "pedido-"+p.id()+".html";
        this.arq = new FileWriter(new File(nomeArq), true);
        this.pedido = p;
        p.conectar(this);
    }
    @Override
    public void atualizar() {
        List<Comida> lista = this.pedido.getPedido().getComidas();
        Comida comida = lista.get(lista.size()-1);

        try{
            this.arq.append("<div class=\"comida\">\n\t<p>"+comida.descricao+"</p>\n");
            this.arq.append("\t<p>"+comida.precoFinal()+"</p>\n</div>\n");
        }
        catch(IOException ex){
            System.out.println(comida);
        }
    }

    public void fechar() throws IOException{
        this.arq.close();
    }
}
