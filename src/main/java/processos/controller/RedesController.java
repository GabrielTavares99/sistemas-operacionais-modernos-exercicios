package processos.controller;

public class RedesController {

    LinuxControllerI linuxController = new LinuxControllerI();
    WindowsController windowsController = new WindowsController();

    public String ip(String soName) {
        StringBuilder adaptador = null;
        if (soName.equalsIgnoreCase("Linux")) {
            adaptador = linuxController.adaptadorRede(adaptador);
        } else if (soName.contains("Windows")) {
            adaptador = windowsController.adaptadorRede(adaptador);
        }
        return adaptador.toString();
    }

    public String ping(String osName) {
        double mediaVelocidade = 0;
        if (osName.equalsIgnoreCase("Linux"))
            mediaVelocidade = linuxController.ping();
        else if (osName.contains("Windows"))
            mediaVelocidade = windowsController.ping();

        return String.format("%.1f ms", mediaVelocidade);
    }
}
