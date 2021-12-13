import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VerificaComida extends Observador{
    private List<PedidoObersavel> pedidos;

    public VerificaComida(){
        this.pedidos = new ArrayList<>(20);
    }
    public void addPedido(PedidoObersavel p){
        this.pedidos.add(p);
        p.conectar(this);
    }

    @Override
    public void atualizar() {
        LinkedList<Comida> todos = new LinkedList<>();
        for(PedidoObersavel pedido : pedidos){
            todos.addAll(pedido.getPedido().getComidas());
        }

        if(todos.size() > 10){
            System.out.println("Quantidade maior que o possível");
        }
    }
}
