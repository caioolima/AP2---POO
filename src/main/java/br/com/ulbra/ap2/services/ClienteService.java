package br.com.ulbra.ap2.services;

import br.com.ulbra.ap2.model.Cliente;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Cliente getClienteById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientesByName(String filterName) {
        List<Cliente> filteredClientes = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.getNome(), filterName)){
                filteredClientes.add(cliente);
                break;
            }
        }
        return filteredClientes;
    }

    public List<Cliente> getClientesByAge(int idade) {
        List<Cliente> filteredClientes = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() == idade) {
                filteredClientes.add(cliente);
            }
        }
        return filteredClientes;
    }

    public Cliente addCliente(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente updateCliente(int id, Cliente updatedCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getId() == id) {
                updatedCliente.setId(id);
                clientes.set(i, updatedCliente);
                return updatedCliente;
            }
        }
        return null;
    }

    public boolean deleteCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

}