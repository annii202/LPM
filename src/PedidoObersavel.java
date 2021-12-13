import java.util.HashSet;
import java.util.Set;

public class PedidoObersavel implements IAssunto{
    private Set<Observador> observadores;
    private Pedido pedido;
    public PedidoObersavel(){
        this.pedido = new Pedido();
        this.observadores = new HashSet<>();
    }

    public void add(Comida comida){
        this.pedido.addComida(comida);
        this.notificar();
    }

    public int id(){
        return this.pedido.getIdPedido();
    }
    @Override
    public void conectar(Observador os) {
        this.observadores.add(os);
    }

    @Override
    public void desconectar(Observador os) {
        this.observadores.remove(os);
    }

    @Override
    public void notificar() {
        this.observadores.forEach(Observador::atualizar);
    }

    public Pedido getPedido(){
        return this.pedido;
    }
}
