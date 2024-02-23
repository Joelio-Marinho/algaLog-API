package com.algaworks.algalog.algalogapi.Service;

import com.algaworks.algalog.algalogapi.Model.Cliente;
import com.algaworks.algalog.algalogapi.Model.Exception.ClienteException;
import com.algaworks.algalog.algalogapi.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar (Cliente cliente){

        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente-> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw new ClienteException("ja existe um cliente com este e-mail");
        }
        return clienteRepository.save(cliente);

    }
    public void delete(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

    public Cliente buscar(Long cliente_id){
       return clienteRepository.findById(cliente_id).orElseThrow(()-> new ClienteException("Cliente não encontrado"));
    }
}
