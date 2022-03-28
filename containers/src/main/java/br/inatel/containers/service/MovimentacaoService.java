package br.inatel.containers.service;

import br.inatel.containers.model.Movimentacao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovimentacaoService {

    private Map<Long, Movimentacao> mapa = new HashMap<>();
    private Long index;

    public MovimentacaoService() {
        this.index = Long.valueOf(0);
    }

    public Movimentacao create(Movimentacao obj){

        Long novaId = index++;
        obj.setId(novaId);

        mapa.put(novaId, obj); // criaria uma consulta no banco de dados(inserir dados)

        return obj;
    }

    public List<Movimentacao> readAll(){

        return mapa.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList()); // MAP é funcao que separa cada objeto

    }

    public Movimentacao getMovimentacaoById(Long MovimentacaoId){

        return mapa.get(MovimentacaoId);

    }

    public void update(Long id, Movimentacao movimentacao){

        mapa.put(movimentacao.getId(), movimentacao);

    }

    public void delete(Long movimentacaoId){

        mapa.remove(movimentacaoId);

    }

}
