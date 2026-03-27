package com.weg.estrutura.pedagogica.Service;



import com.weg.estrutura.pedagogica.Dto.Requisicao.CategoriaRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.CategoriaRespostaDto;
import com.weg.estrutura.pedagogica.Model.Categoria;
import com.weg.estrutura.pedagogica.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaRespostaDto cadastrar(CategoriaRequisicaoDto dto) {

        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());

        Categoria salva = repository.save(categoria);

        return new CategoriaRespostaDto(salva);
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public CategoriaRespostaDto buscarDtoPorId(Long id) {
        return new CategoriaRespostaDto(buscarPorId(id));
    }
}