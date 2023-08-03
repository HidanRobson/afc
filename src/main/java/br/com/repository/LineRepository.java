package br.com.repository;

import br.com.entity.LineEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LineRepository implements PanacheRepository<LineEntity> {
    
}
