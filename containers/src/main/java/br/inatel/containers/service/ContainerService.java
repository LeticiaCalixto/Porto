package br.inatel.containers.service;

import br.inatel.containers.model.Container;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContainerService {

    private Map<Long, Container> mapa = new HashMap<>();
    private Long index;

    public ContainerService() {
        this.index = Long.valueOf(0);
    }

    public Container create(Container obj){

        Long novaId = index++;
        obj.setId(novaId);

        mapa.put(novaId, obj); // criaria uma consulta no banco de dados(inserir dados)

        return obj;
    }

    public List<Container> readAll(){

        return mapa.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList()); // MAP é funcao que separa cada objeto

    }

    public Container getContainerById(Long containerId){

        return mapa.get(containerId);

    }

    public void update(Long id, Container container){

        mapa.put(container.getId(), container);

    }

    public void delete(Long containerId){

        mapa.remove(containerId);

    }

}
