public interface IAssunto {
    public void conectar(Observador os);
    public void desconectar(Observador os);
    public void notificar();
}
