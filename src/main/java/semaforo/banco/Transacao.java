package semaforo.banco;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Transacao extends Thread {

    private int transacao_id;
    private Semaphore semaphoreSaque;
    private Semaphore semaphoreDeposito;
    private String codConta;
    private TipoTransacao tipoTransacao;
    private final Double valorTransacao;
    static int saque;
    static int deposito;
    static Semaphore semaphoreGeral = new Semaphore(2);

    static Map<String, Double> CONTAS = new HashMap<>();

    public Transacao(int transacao_id, Semaphore semaphoreSaque, Semaphore semaphoreDeposito, String codConta, TipoTransacao tipoTransacao, Double valorTransacao) {
        this.transacao_id = transacao_id;
        this.semaphoreSaque = semaphoreSaque;
        this.semaphoreDeposito = semaphoreDeposito;
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
            semaphoreGeral.acquire();

            if (tipoTransacao.equals(TipoTransacao.DEPOSITO)) {
                semaphoreDeposito.acquire();
                deposito++;
            } else {
                semaphoreSaque.acquire();
                saque++;
            }

            saldoConta = CONTAS.get(codConta);
            System.out.println(String.format("Transação #%d de %s na conta %s, saldo %.2f, valor transação %.2f INICIANDO OPERAÇÃO",
                    transacao_id, tipoTransacao.toString(), codConta, saldoConta, valorTransacao));
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
            if (tipoTransacao.equals(TipoTransacao.DEPOSITO)) {
                deposito--;
                semaphoreDeposito.release();
            }else {
                saque--;
                semaphoreSaque.release();
            }
            semaphoreGeral.release();
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
