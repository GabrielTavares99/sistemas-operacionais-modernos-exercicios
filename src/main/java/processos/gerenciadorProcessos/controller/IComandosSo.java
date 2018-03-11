package processos.gerenciadorProcessos.controller;

public interface IComandosSo {

    String identificaSO();

    boolean mataProcessoByPID(int pid);

    boolean mataProcessoByNomeProcesso(String nomeProcesso);

    void listaProcessos();
}
