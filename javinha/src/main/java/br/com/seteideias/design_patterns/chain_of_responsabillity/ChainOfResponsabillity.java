package br.com.seteideias.design_patterns.chain_of_responsabillity;

import java.util.Arrays;

public class ChainOfResponsabillity {

        public static void main(String[] args) {
            Approver chaves = new ChavesApprover();
            Approver madruga = new SeuMadrugaApprover();
            Approver barriga = new SrBarrigaApprover();
            Approver florinda = new DonaFlorindaApprover();

            chaves.setNext(madruga);
            madruga.setNext(barriga);
            barriga.setNext(florinda);

            double[] requests = {1, 500, 3000, 15000, 200, 50000};
            Arrays.stream(requests).forEach(it -> {
                System.out.println("-------------- novo emprestimo solicitado de R$ " + it);
                chaves.approveLoan(it);
            });
        }

}

abstract class Approver {
    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void approveLoan(double amount);
}

class ChavesApprover extends Approver {
    @Override
    public void approveLoan(double amount) {
        System.out.println("Chaves vai aprovar?");
        if (amount <= 1000) {
            System.out.println("Chaves aprovou o empréstimo de R$ " + amount);
        } else if (next != null) {
            System.out.println("Chaves nao aprovou");
            next.approveLoan(amount);
        }
    }
}

class SeuMadrugaApprover extends Approver {
    @Override
    public void approveLoan(double amount) {
        System.out.println("Seu Madruga vai aprovar?");
        if (amount <= 5000) {
            System.out.println("Seu Madruga aprovou o empréstimo de R$ " + amount);
        } else if (next != null) {
            System.out.println("Seu Madruga nao aprovou");
            next.approveLoan(amount);
        }
    }
}

class SrBarrigaApprover extends Approver {
    @Override
    public void approveLoan(double amount) {
        System.out.println("Sr Barriga vai aprovar?");
        if (amount <= 20000) {
            System.out.println("Sr. Barriga aprovou o empréstimo de R$ " + amount);
        } else if (next != null) {
            System.out.println("Sr. Barriga nao aprovou");
            next.approveLoan(amount);
        }
    }
}

class DonaFlorindaApprover extends Approver {
    @Override
    public void approveLoan(double amount) {
        System.out.println("Dona Florinda aprovou o empréstimo de R$ " + amount + " sem limite!");
    }
}
