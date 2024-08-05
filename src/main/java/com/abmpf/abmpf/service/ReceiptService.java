package com.abmpf.abmpf.service;

import com.abmpf.abmpf.entities.Client;
import com.abmpf.abmpf.entities.Product;
import com.abmpf.abmpf.entities.Receipt;
import com.abmpf.abmpf.entities.ReceiptDetail;
import com.abmpf.abmpf.repository.ClientRepository;
import com.abmpf.abmpf.repository.ProductRepository;
import com.abmpf.abmpf.repository.ReceiptRepository;
import com.abmpf.abmpf.repository.ReceiptDetailRepository;
import com.abmpf.abmpf.request.ProductRequest;
import com.abmpf.abmpf.request.ReceiptRequest;
import com.abmpf.abmpf.request.WorldClockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private ReceiptDetailRepository receiptDetailRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Receipt createReceipt(ReceiptRequest receiptRequest) throws Exception {
        Optional<Client> clientOpt = clientRepository.findById(receiptRequest.getClient().getClientId());
        if (clientOpt.isEmpty()) {
            throw new Exception("Client not found");
        }

        Client client = clientOpt.get();
        Receipt receipt = new Receipt();
        receipt.setClient(client);
        receipt.setCreatedAt(getCurrentDate());

        List<ReceiptDetail> receiptDetails = new ArrayList<>();
        double total = 0;

        for (ReceiptRequest.Line line : receiptRequest.getLines()) {
            Optional<Product> productOpt = productRepository.findById(line.getProduct().getId());
            if (productOpt.isEmpty()) {
                throw new Exception("Product not found");
            }

            Product product = productOpt.get();
            if (product.getStock() < line.getAmount()) {
                throw new Exception("Insufficient stock for product: " + product.getDescription());
            }

            product.setStock(product.getStock() - line.getAmount());
            productRepository.save(product);

            ReceiptDetail receiptDetail = new ReceiptDetail();
            receiptDetail.setReceipt(receipt);
            receiptDetail.setProduct(product);
            receiptDetail.setAmount(line.getAmount());
            receiptDetail.setPrice(product.getPrice());
            receiptDetails.add(receiptDetail);

            total += product.getPrice() * line.getAmount();
        }

        receipt.setTotal(total);
        receipt.setDetails(receiptDetails);

        receiptRepository.save(receipt);
        receiptDetailRepository.saveAll(receiptDetails);

        return receipt;
    }

    private LocalDateTime getCurrentDate() {
        try {
            String url = "http://worldclockapi.com/api/json/utc/now";
            WorldClockResponse response = restTemplate.getForObject(url, WorldClockResponse.class);
            if (response != null && response.getCurrentDateTime() != null) {
                return LocalDateTime.parse(response.getCurrentDateTime());
            } else {
                throw new Exception("Invalid response from World Clock API");
            }
        } catch (Exception e) {
            return LocalDateTime.now();
        }
    }
}
