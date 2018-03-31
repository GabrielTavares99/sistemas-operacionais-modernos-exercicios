package semaforo.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import static semaforo.banco.Transacao.CONTAS;

public class Principal {

    public static void main(String[] args) {
        String codConta;

        List<TipoTransacao> tiposTransacao = new ArrayList<>();
        Random random = new Random();
        tiposTransacao.add(TipoTransacao.DEPOSITO);
        tiposTransacao.add(TipoTransacao.SAQUE);

        int qtdContas = 1;
        for (int i = 1; i <= qtdContas; i++) {
            codConta = String.format("cod%d", i);
            CONTAS.put(codConta, random.nextDouble() * 100);
        }

        List<String> codigosConta = new ArrayList<>();
        codigosConta.addAll(CONTAS.keySet());
        Semaphore semaphore = new Semaphore(2);
        for (int i = 1; i <= 20; i++) {
            TipoTransacao tipoTransacao = tiposTransacao.get(random.nextInt(tiposTransacao.size()));
            new Transacao(i, semaphore, codigosConta.get(random.nextInt(codigosConta.size())).toString(), tipoTransacao, random.nextDouble() * 100).start();
        }

    }
}
