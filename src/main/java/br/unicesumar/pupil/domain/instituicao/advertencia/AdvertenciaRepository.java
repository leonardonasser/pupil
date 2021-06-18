package br.unicesumar.pupil.domain.instituicao.advertencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, String> {

}
