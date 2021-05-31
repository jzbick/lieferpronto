package com.lieferpronto.lieferpronto.deliveryman.components;

import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
import com.lieferpronto.lieferpronto.deliveryman.repository.DeliverymanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeliverymanService {

    private final DeliverymanRepository deliverymanRepository;

    public Optional<Deliveryman> findById(UUID id) {
        return deliverymanRepository.findById(id);
    }

    public List<Deliveryman> findAll() {
        var deliverymans = new ArrayList<Deliveryman>();
        deliverymanRepository.findAll().forEach(deliveryman::add);
        return deliverymans;
    }

    public Deliveryman saveDeliveryman(Deliveryman deliveryman) {
        deliverymanRepository.save(deliveryman);
        return deliveryman;
    }

    public void deleteDeliveryman(Deliveryman deliveryman) {
        deliverymanRepository.deleteById(deliveryman.getId());
    }
}
