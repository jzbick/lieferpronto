package com.lieferpronto.lieferpronto.deliveryman.components;

import com.lieferpronto.lieferpronto.address.components.AddressService;
import com.lieferpronto.lieferpronto.address.models.Address;
import com.lieferpronto.lieferpronto.deliveryman.models.Deliveryman;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/deliveryman")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class DeliverymanController {

    private final DeliverymanService deliverymanService;
    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<Deliveryman> getDeliverymanById(@PathVariable String id) {
        Optional<Deliveryman> deliveryman = deliverymanService.findById(UUID.fromString(id));
        if (deliveryman.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(deliveryman.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Deliveryman>> getDeliverymans() {
        return new ResponseEntity<>(deliverymanService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateDeliveryman(@RequestBody Deliveryman deliveryman) {
        Address address = deliveryman.getAddress();
        Optional<Address> optionalAddress = addressService.findAddressByCityAndZipAndStreet(address);
        optionalAddress.ifPresentOrElse(
            deliveryman::setAddress,
            () -> {
                address.setId(addressService.saveAddress(address).getId());
                deliveryman.setAddress(address);
            }
        );
        UUID deliverymanId = deliverymanService.saveDeliveryman(deliveryman).getId();
        return new ResponseEntity<>(String.format("Successfully updated or created deliveryman with id: %s",
            deliverymanId),
            HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeliveryman(@PathVariable UUID id) {
        Optional<Deliveryman> deliverymanOptional = deliverymanService.findById(id);

        if (deliverymanOptional.isEmpty()) {
            return new ResponseEntity<>(String.format("Deliveryman with id: %s doesn't exist", id), HttpStatus.NOT_FOUND);
        }
        deliverymanService.deleteDeliveryman(deliverymanOptional.get());
        return new ResponseEntity<>(String.format("Successfully deleted deliveryman with id: %s", deliverymanOptional.get().getId()),
            HttpStatus.OK);
    }
}
