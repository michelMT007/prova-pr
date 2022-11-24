package com.michel.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.michel.entities.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}
