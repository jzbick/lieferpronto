package com.lieferpronto.lieferpronto.deliveryman.components;

import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
import com.lieferpronto.lieferpronto.deliveryman.repository.DeliverymanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeliverymanService {

    private final DeliverymanRepository deliverymanRepository;

    public List<Deliveryman> findAll() {

        var deliveryman = new ArrayList<Deliveryman>();
        deliverymanRepository.findAll().forEach(deliveryman::add);

        return deliveryman;
    }

    public ResponseEntity<Deliveryman> createOrder(Deliveryman deliveryman) {
        deliverymanRepository.save(deliveryman);
        return new ResponseEntity<>(deliveryman, HttpStatus.CREATED);
    }
}
