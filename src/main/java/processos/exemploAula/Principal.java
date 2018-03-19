package processos.exemploAula;

public class Principal {
    public static void main(String[] args) {

        ProcController procController = new ProcController();

        System.out.println(procController.os());

//        procController.propriedades();

//        String caminhoProcesso = "vlc";
//        String caminhoProcesso = "C:\\windows\\notepad.exe";
//        procController.chamaProcesso(caminhoProcesso);
        procController.leProcesso("traceroute www.google.com");

//        procController.mataProcesso("vlc");
    }
}
