package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.execao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class Titulo implements Comparable<Titulo> {

        private String nome;
        private int anoDeLancamento;
        private boolean incluidoNoPlano;
        private int duracaoEmMinutos;
        private double somaDasAvaliacoes;
        private int totalDeAvaliacao;


        public Titulo(String nome, int anoDeLancamento) {
            this.nome = nome;
            this.anoDeLancamento = anoDeLancamento;
        }

        public Titulo(TituloOmdb meuTituloOmdb) {
            this.nome = meuTituloOmdb.title();
            if(meuTituloOmdb.year().length() > 4){
                throw new ErroDeConversaoDeAnoException("Não consegui converter o ano");
            }
            this.anoDeLancamento = Integer.valueOf (meuTituloOmdb.year());
            this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));

        }

        public String getNome() {
                return nome;
            }

        public int getAnoDeLancamento() {
            return anoDeLancamento;
        }

        public boolean isIncluidoNoPlano() {
            return incluidoNoPlano;
        }

        public int getDuracaoEmMinutos() {
            return duracaoEmMinutos;
        }

        public int getTotalDeAvaliacao(){
            return totalDeAvaliacao;
        }

        public boolean setIncluidoNoPlano(boolean incluidoNoPlano) {
            this.incluidoNoPlano = incluidoNoPlano;
            return incluidoNoPlano;
        }

        public void setDuracaoEmMinutos(int duracaoEmMinutos) {
            this.duracaoEmMinutos = duracaoEmMinutos;
        }

        public void setAnoDeLancamento(int anoDeLancamento) {
            this.anoDeLancamento = anoDeLancamento;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void  exibeFichaTecnica() {
            System.out.println("Nome: " + nome);
            System.out.println("Ano de Lançamento: " + anoDeLancamento);
        }

        public void avalia(double nota){
            somaDasAvaliacoes += nota;
            totalDeAvaliacao += 1;
        }

        public double pegaMedia(){
            return somaDasAvaliacoes / totalDeAvaliacao;
        }

        @Override
        public int compareTo(Titulo outroTitulo) {
            return this.getNome().compareTo(outroTitulo.getNome());
        }

    @Override
    public String toString() {
        return "(Nome = '" + nome +
                ", Lançamento = " + anoDeLancamento + ", " +
                "Duração: " + duracaoEmMinutos + ")";
    }
}
