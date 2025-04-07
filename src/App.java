import java.util.Random;

/** 
 * MIT License
 *
 * Copyright(c) 2024-255 João Caram <caram@pucminas.br>
 *                       Eveline Alonso Veloso
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class App {
    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random(42);
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    static double duracao;

    /**
     * Código de teste 1. Este método... Conta os números ímpares em posições pares do vetor.
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo1(int[] vetor) {
        int resposta = 0;
        operacoes = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            operacoes += 4;
            resposta += vetor[i]%2;
        }
        return resposta;
    }

    /**
     * Código de teste 2. Este método... Soma todos os logaritmos
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }

        }
        return contador;
    }

    /**
     * Código de teste 3. Este método... Algoritmo de ordenação por seleção.
     * @param vetor Vetor com dados para teste.
     */
    static void codigo3(int[] vetor) {
        operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                operacoes++;
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    /**
     * Código de teste 4 (recursivo). Este método... 
     * @param n Ponto inicial do algoritmo
     * @return Um inteiro que significa...
     */
    static int codigo4(int n) {
        if (n <= 2){
            operacoes++;
            return 1;
        }else{
            operacoes+= 2;
            return codigo4(n - 1) + codigo4(n - 2);
        }
    }

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            operacoes++;
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        operacoes++;
        return vetor;
        
    }

    public static String executarTeste(int[] vetor){
        marcarTempo(vetor);
        return String.format("Tamanho: %,2d | Operações: %,2d | Tempo:%,2f ms", vetor.length, operacoes, duracao);
    }

    public static void marcarTempo(int[] vetor){
        long inicio = System.nanoTime();
        codigo3(vetor);
        duracao = (System.nanoTime()-inicio)*nanoToMilli;
    }

    public static void main(String[] args) {
        int[] tamanhoTeste = tamanhosTestePequeno;
        for(int i = 0; i < tamanhoTeste.length; i++){
            long inicio = System.nanoTime();
            codigo4(tamanhoTeste[i]);
            duracao = (System.nanoTime()-inicio)*nanoToMilli;
            System.out.printf("Tamanho: %,2d | Operações: %,2d | Tempo:%,2f ms", tamanhoTeste[i], operacoes, duracao);
        }
    }
}