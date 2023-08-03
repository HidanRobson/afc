package br.com.service;

import br.com.dto.LineDTO;
import br.com.entity.LineEntity;
import br.com.repository.LineRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class LineService {
    
    @Inject
    private LineRepository lineRepository;

    public List<LineDTO> findAllLines(){
        List<LineDTO> lines = new ArrayList<>();
        lineRepository.findAll().stream().forEach(item->{
            lines.add(mapLineEntityToDTO(item));
        });
        return lines;
    }

    public void createNewLine(LineDTO lineDTO){
       lineRepository.persist(mapLineDTOToEntity(lineDTO));
    }

    public void changeLine(Long id, LineDTO lineDTO){

        LineEntity line = lineRepository.findById(id);

        line.setName(lineDTO.getName());
        line.setLider(lineDTO.getLider());
        line.setType(lineDTO.getType());
        line.setDescription(lineDTO.getDescription());
        line.setMenbers(lineDTO.getMenbers());
        line.setCreated_AT(lineDTO.getCreated_AT());
        
        lineRepository.persist(line);
    }

    public void deleteLine(Long id){
        lineRepository.deleteById(id);
    }

    // Map LineDTO to LineEntity
    private LineDTO mapLineEntityToDTO(LineEntity line){

        LineDTO lineDTO  = new LineDTO();

        lineDTO.setName(line.getName());
        lineDTO.setLider(line.getLider());
        lineDTO.setType(line.getType());
        lineDTO.setDescription(line.getDescription());
        lineDTO.setMenbers(line.getMenbers());
        lineDTO.setCreated_AT(line.getCreated_AT());

        return lineDTO;
    }

    // Map LineEntity to LineDTO
    private LineEntity mapLineDTOToEntity(LineDTO line){

        LineEntity lineEntity = new LineEntity();

        lineEntity.setName(line.getName());
        lineEntity.setLider(line.getLider());
        lineEntity.setType(line.getType());
        lineEntity.setDescription(line.getDescription());
        lineEntity.setMenbers(line.getMenbers());
        lineEntity.setCreated_AT(line.getCreated_AT());

        return lineEntity;
    }
}
