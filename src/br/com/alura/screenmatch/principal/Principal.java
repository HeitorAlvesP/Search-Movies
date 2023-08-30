package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroDeRecomendacao;
import br.com.alura.screenmatch.modelos.Epsodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        //meu Filme
        var meuFilme = new Filme("Carros", 2000);
        meuFilme.setDuracaoEmMinutos(180);

        //Execução 1
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(9);
        System.out.println("Quantidades de votos é " + meuFilme.getTotalDeAvaliacao());
        System.out.println("A media do filme é " + meuFilme.pegaMedia());

        //Minhas Serie
        var lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpsidiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar losta: " + lost.getDuracaoEmMinutos());

        //Outro Filme
        var novoFilme = new Filme("Avatar", 1999);
        novoFilme.setDuracaoEmMinutos(200);

        //Calculo total de tempo
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(novoFilme);
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        //Aqui é um filtro nd haver
        var filtro = new FiltroDeRecomendacao();
        filtro.filtra(meuFilme);

        //Informe sobre um epsodio(cria ele)
        var epsodio = new Epsodio();
        epsodio.setNumero(1);
        epsodio.setSerie(lost);
        epsodio.setTotalDeVizualizacoes(300);
        filtro.filtra(epsodio);

        //Mais um Filme
        var filmedoPaulo = new Filme("Dogville", 2003);
        filmedoPaulo.setDuracaoEmMinutos(200);
        filmedoPaulo.avalia(10);

        //Primeria Lista de Filmes
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmedoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(novoFilme);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro flme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());


    }
}