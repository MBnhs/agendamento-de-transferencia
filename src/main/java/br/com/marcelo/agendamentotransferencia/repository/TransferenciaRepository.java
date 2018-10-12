package br.com.marcelo.agendamentotransferencia.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public interface TransferenciaRepository extends CrudRepository<Transferencia, Long> {

}
