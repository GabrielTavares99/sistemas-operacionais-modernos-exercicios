package processos.gerenciadorProcessos.controller;

public class ProcessosController {

    LinuxController linuxController = new LinuxController();

    public String identificaSO() {
        return System.getProperty("os.name");
    }

    public boolean mataProcessoByPID(String soName, int pid) {
        if (identificaSO().contains("Linux")) {
            linuxController.mataProcessoByPID(pid);
        }
        return false;
    }

    public boolean mataProcessoByNomeProcesso(String soName, String nomeProcesso) {
        if (identificaSO().contains("Linux")) {
            linuxController.mataProcessoByNomeProcesso(nomeProcesso);
        }
        return false;
    }

    public void listaProcessos(String soName) {
        if (identificaSO().contains("Linux")) {
            linuxController.listaProcessos();
        }
    }

}
