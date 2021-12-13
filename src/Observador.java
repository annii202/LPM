public abstract class Observador {
    public abstract void atualizar();

    public void registrar(IAssunto observado){
        observado.conectar(this);
    }
}
