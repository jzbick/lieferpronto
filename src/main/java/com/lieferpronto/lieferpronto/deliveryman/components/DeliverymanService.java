package com.lieferpronto.lieferpronto.deliveryman.components;

import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
import com.lieferpronto.lieferpronto.deliveryman.repository.DeliverymanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeliverymanService {

    private final DeliverymanRepository deliverymanRepository;

    public Optional<Deliveryman> findById(UUID id) {
        return deliverymanRepository.findById(id);
    }

    public List<Deliveryman> findAll() {
        var deliverymen = new ArrayList<Deliveryman>();
        deliverymanRepository.findAll().forEach(deliverymen::add);
        return deliverymen;
    }

    public Deliveryman saveDeliveryman(Deliveryman deliveryman) {
        deliverymanRepository.save(deliveryman);
        return deliveryman;
    }

    public void deleteDeliveryman(Deliveryman deliveryman) {
        deliverymanRepository.deleteById(deliveryman.getId());
    }
}
