package polynomial;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    // lista de termos do polinômio

    ArrayList<Term> terms;

    // representa um termo da lista de polinômios
    public class Term implements Comparable<Term> {

        private double coef;
        private int expo;

        public Term(int expo) {
            this(1.0, expo);
        }

        public Term(double coef, int expo) {
            this.coef = coef;
            this.expo = expo;
        }
        // calcula o valor do termo no ponto
        // x : coef*x^expo

        public double valueAt(double x) {
            return coef * Math.pow(x, expo);
        }

        // converter termo para string
        @Override
        public String toString() {
            return String.format("%5.2f*X^%d", coef, expo);
        }

        // verificar se termos são iguais
        @Override
        public boolean equals(Object o) {
            // se é o prório objeto, retorne true
            if (o == this) {
                return true;
            }
            // se o objeto não for um termo, retorne false
            if (!(o instanceof Term)) {
                return false;
            }
            // converter objeto para termo
            Term term = (Term) o;
            // comparar termos - mesmo expoente
            if (this.expo == term.expo) {
                return true;
            } else {
                return false;
            }
        }

        // uso para tabela de hash
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 71 * hash + this.expo;
            return hash;
        }

        // comparação de termos
        @Override
        public int compareTo(Term t) {
            // resultado:
            // <0: this < t
            // 0: this = t
            // >0: this > t
            return this.expo - t.expo;
        }
    }

    // cria um polinomio vazio
    public Polynomial() {
        this.terms = new ArrayList<>();
    }
    // adiciona um termo de ordem expo e coeficiente coef

    public void add(double coef, int expo) {
        Term nt = new Term(coef, expo);
        int i;
        // se o termo já existe
        if ((i = terms.indexOf(nt)) >= 0) {
            // obter o termo
            Term t = terms.get(i);
            // adicionar seus coeficientes
            t.coef += nt.coef;
        } else {
            // adicionar novo termo
            terms.add(nt);
        }
        // ordena os termos por grau
        Collections.sort(terms);
    }
    // remover um termo de grau expo de um polinômio

    public void remove(int expo) {
        int i;
        // se o termo já existe
        if ((i = terms.indexOf(new Term(expo))) >= 0) {
            terms.remove(i);
        }
    }

    // calcula o valor do polinomio no ponto x
    public double valueAt(double x) {
        double r = 0.0;
        for (int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
            r += t.coef * Math.pow(x, t.expo);
        }
        return r;
    }
    // exibir na tela um polinômio

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
            String st = t.toString();
            s += (t.coef > 0) ? (" +" + st) : ("" + st);
        }
        return s;
    }

    public static Polynomial sum(Polynomial p1, Polynomial p2) {
        Polynomial r = new Polynomial();
        for(Term t : p1.terms){
            r.add(t.coef, t.expo);
        }
        for(Term t : p2.terms){
            r.add(t.coef, t.expo);
        }
        return r;
    }

}
