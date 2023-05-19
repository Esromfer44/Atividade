package com.iftm.client.service;

import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.ClientService;
import com.iftm.client.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService servico;

    @Mock
    private ClientRepository repositorio;

    @DisplayName("Testar se o método deleteById apaga um registro e não retorna outras informações")
    @Test
    public void testarApagarPorIdTemSucessoComIdExistente() {
        //cenário
        long idExistente = 1;
        //configurando mock : definindo que o método deleteById não retorna nada para esse id.
        Mockito.doNothing().when(repositorio).deleteById(idExistente);

        Assertions.assertDoesNotThrow(() -> {
            servico.delete(idExistente);
        });
        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idExistente);

    }

    @DisplayName("Testar se o método deleteById retorna exception para idInexistente")
    @Test
    public void testarApagarPorIdGeraExceptionComIdInexistente() {
        //cenário
        long idNaoExistente = 100;
        //configurando mock : definindo que o método deleteById retorna uma exception para esse id.
        Mockito.doThrow(ResourceNotFoundException.class).when(repositorio).deleteById(idNaoExistente);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> servico.delete(idNaoExistente));

        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idNaoExistente);

    }
    @Test
    void findAllPaged_shouldReturnPageWithAllClientsAndCallRepositoryFindAll() {

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1L, "Genilson"));
        clients.add(new Client(2L, "Pedro Lucas"));
        Page<Client> expectedPage = new PageImpl<>(clients);
        when(clientRepository.findAll(any(Pageable.class))).thenReturn(expectedPage);


        Page<Client> resultPage = clientService.findAllPaged(0, 10);


        assertEquals(expectedPage, resultPage);
        verify(clientRepository, times(1)).findAll(any(Pageable.class));
    }
    @Test
    void findByIncome_shouldReturnPageWithClientsMatchingIncomeAndCallRepositoryFindByIncome() {

        double income = 5000.0;
        List<Client> matchingClients = new ArrayList<>();
        matchingClients.add(new Client(1L, "Genilson", income));
        Page<Client> expectedPage = new PageImpl<>(matchingClients);
        when(clientRepository.findByIncome(income, any(Pageable.class))).thenReturn(expectedPage);


        Page<Client> resultPage = clientService.findByIncome(income, 0, 10);


        assertEquals(expectedPage, resultPage);
        verify(clientRepository, times(1)).findByIncome(income, any(Pageable.class));
    }
    @Test
    void findById_shouldReturnClientDTOWhenIdExists() {
        // Arrange
        long existingId = 1L;
        Client existingClient = new Client(existingId, "Genilson");
        when(clientRepository.findById(existingId)).thenReturn(Optional.of(existingClient));

        ClientDTO resultDTO = clientService.findById(existingId);

        assertNotNull(resultDTO);
        assertEquals(existingId, resultDTO.getId());
        assertEquals(existingClient.getName(), resultDTO.getName());
    }

    @Test
    void findById_shouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        long nonExistingId = 2L;
        when(clientRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            clientService.findById(nonExistingId);
        });
    }
    @Test
    void update_shouldReturnClientDTOWhenIdExists() {

        long existingId = 1L;
        Client existingClient = new Client(existingId, "Genilson");
        ClientDTO updatedDTO = new ClientDTO(existingId, "Pedro Lucas");
        when(clientRepository.findById(existingId)).thenReturn(Optional.of(existingClient));
        when(clientRepository.save(existingClient)).thenReturn(existingClient);

        ClientDTO resultDTO = clientService.update(existingId, updatedDTO);

        assertNotNull(resultDTO);
        assertEquals(existingId, resultDTO.getId());
        assertEquals(updatedDTO.getName(), resultDTO.getName());
    }

    @Test
    void update_shouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        long nonExistingId = 2L;
        ClientDTO updatedDTO = new ClientDTO(nonExistingId, "Pedro Lucas");
        when(clientRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            clientService.update(nonExistingId, updatedDTO);
        });
    }
    @Test
    void insert_shouldReturnClientDTOWhenInsertingNewClient() {

        ClientDTO newClientDTO = new ClientDTO(1L, "Pedro Lucas");
        Client newClient = new Client(newClientDTO.getId(), newClientDTO.getName());
        when(clientRepository.save(any(Client.class))).thenReturn(newClient);

        ClientDTO resultDTO = clientService.insert(newClientDTO);

        assertNotNull(resultDTO);
        assertEquals(newClientDTO.getId(), resultDTO.getId());
        assertEquals(newClientDTO.getName(), resultDTO.getName());
    }
}
