package processos.controller;

import java.util.Properties;
import java.util.Set;

public class ProcController {

    public ProcController() {
//        O super pega alguns métodos da classe object
        super();
    }

    public String os() {
        return System.getProperty("os.name");
    }

    public void propriedades() {
        Properties properties = System.getProperties();
        Set<Object> chaves = properties.keySet();
        for (Object key: chaves) {
            System.out.print(key);
            System.out.print("=");
            System.out.println(System.getProperty(key.toString()));
        }
    }

}
