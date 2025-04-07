import java.util.Comparator;

public class ComparadorValorDesempateAlfabetico  implements Comparator<Produto>{
    @Override
    public int compare(Produto o1, Produto o2){
        int resposta = 0;
        resposta = (o1.valorDeVenda() > o2.valorDeVenda()? 1: -1);
        if(o1.valorDeVenda() != o2.valorDeVenda()){
            resposta = o1.compareTo(o2);
        }else{
            resposta = (o1.valorDeVenda() > o2.valorDeVenda()? 1: -1);
        }
        return resposta;

        //if(o1.valorDeVenda() > o2.valorDeVenda())
        //  resposta = 1;
        //else if(o1.valorDeVenda < o2.valorDeVenda())
        //  resposta = -1;
    }   
    
}
