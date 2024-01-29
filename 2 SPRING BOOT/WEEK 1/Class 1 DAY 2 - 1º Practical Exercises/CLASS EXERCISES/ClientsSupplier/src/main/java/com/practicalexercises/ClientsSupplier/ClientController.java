package com.practicalexercises.ClientsSupplier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<ClientModel> getAll(){
        List<ClientModel> clients = new ArrayList<>();
        for (int i=0; i<10;i++){
            ClientModel client = new ClientModel(i,"nameClient"+i);
            String[] asd = {"dfvdvdfcjndknckdkcmkdmkcmdkmckdmkddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"};

            clients.add(client);
        }
        return clients;
    }
}
