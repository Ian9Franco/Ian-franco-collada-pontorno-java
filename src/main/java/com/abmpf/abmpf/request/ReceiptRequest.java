package com.abmpf.abmpf.request;

import java.util.List;

public class ReceiptRequest {

    private Client client;
    private List<Line> lines;

    public static class Client {
        private Integer clientId;

        public Integer getClientId() {
            return clientId;
        }

        public void setClientId(Integer clientId) {
            this.clientId = clientId;
        }
    }

    public static class Line {
        private Integer amount;
        private ProductRequest product;

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public ProductRequest getProduct() {
            return product;
        }

        public void setProduct(ProductRequest product) {
            this.product = product;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
