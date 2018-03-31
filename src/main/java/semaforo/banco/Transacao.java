package semaforo.banco;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Transacao extends Thread {

    static String transacoes = "";
    private int transacao_id;
    private Semaphore semaphore;
    private final String codConta;
    private TipoTransacao tipoTransacao;
    private final Double valorTransacao;
    static int saque;
    static int deposito;

    static Map<String, Double> CONTAS = new HashMap<>();

    public Transacao(int transacao_id, Semaphore semaphore, String codConta, TipoTransacao tipoTransacao, Double valorTransacao) {
        this.transacao_id = transacao_id;
        this.semaphore = semaphore;
        this.codConta = codConta;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
    }

    @Override
    public void run() {

        System.out.println(String.format("Transação #%d de %s na conta %s AGUARDANDO",
                transacao_id, tipoTransacao.toString(), codConta));

        Double saldoConta = null;

        try {

            // TODO: 30/03/18 COMO NÃO PERMITIR DUAS OPERAÇÕES AO MESMO TEMPO?

            semaphore.acquire();

            saldoConta = CONTAS.get(codConta);
            System.out.println(String.format("Transação #%d de %s na conta %s, saldo %.2f, valor transação %.2f INICIANDO OPERAÇÃO",
                    transacao_id, tipoTransacao.toString(), codConta, saldoConta, valorTransacao));

            if (tipoTransacao.equals(TipoTransacao.DEPOSITO)) {
                deposito++;
            } else {
                saque++;
            }

            System.out.println("SAQUE " + saque);
            System.out.println("DEPOSITO  " + deposito);

            if (tipoTransacao.equals(TipoTransacao.DEPOSITO)) {
                deposito(codConta, saldoConta, valorTransacao);
            } else {
                saque(codConta, saldoConta, valorTransacao);
            }
            saldoConta = CONTAS.get(codConta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("Transação #%d de %s na conta %s, saldo %.2f  CONCLUÍDA",
                    transacao_id, tipoTransacao.toString(), codConta, saldoConta));
            if (tipoTransacao.equals(TipoTransacao.DEPOSITO))
                deposito--;
            else
                saque--;
            semaphore.release();
        }

    }

    public void saque(String codConta, Double saldoConta, Double valorTransacao) {
        saldoConta -= valorTransacao;
        CONTAS.put(codConta, saldoConta);
    }

    public void deposito(String codConta, Double saldoConta, Double valorTransacao) {
        saldoConta += valorTransacao;
        CONTAS.put(codConta, saldoConta);
    }
}
