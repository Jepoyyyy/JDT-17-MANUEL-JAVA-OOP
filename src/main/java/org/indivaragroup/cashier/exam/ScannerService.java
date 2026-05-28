package org.indivaragroup.cashier.exam;

import java.text.DecimalFormat;
import java.util.*;

public class ScannerService {
    private Scanner input;
    private StringBuilder recipt;
    private int quantity;
    private Double price;
    private Double totalPrice;
    private Double tax;
    private UUID reciptId = UUID.randomUUID();
    private Properties config;
    private Random random;
    private String[] itemList;
    private Double total;
    private int itemCounter = 0;

    private DecimalFormat df = new DecimalFormat("#.##");

    public ScannerService() {
        this.input = new Scanner(System.in);
        this.recipt = new StringBuilder();
        this.quantity = 0;
        this.price = 0.0;
        this.totalPrice = 0.0;
        this.tax = 0.0;
        this.random = new Random();
        this.total = 0.0;
        this.itemList = new String[3];

        this.config = new Properties();
        this.config.setProperty("storeName", "Toko Sumber Makmur Malaria");
        this.config.setProperty("cashierName", "Bambang Gentolet");
    }

    public void runScanner() {
        reciptHeader();
        boolean shopping = true;

        while (shopping) {
            reciptBody();
            itemCounter++;
            if (itemCounter >= 3) {
                System.out.println("\n Maximum Transaction Reached!!!!");
                shopping = false;
            } else {
                boolean validAnswer = false;
                while (!validAnswer) {
                    try {
                        System.out.print("Do you want to add more items? (yes/no): ");
                        String answer = input.nextLine().trim().toLowerCase();

                        if (!answer.matches("yes|y|no|n")) {
                            throw new IllegalArgumentException("Invalid input! Only 'yes' or 'no' are allowed.");
                        }

                        if (answer.matches("no|n")) {
                            shopping = false;
                        }
                        validAnswer = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }
//        Arrays.sort(itemList, 0, this.itemCounter, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < this.itemCounter-1; i++) {
            for (int j = i+1; j < this.itemCounter-i-1; j++) {
                if (itemList[j].compareToIgnoreCase(itemList[j + 1]) > 0) {
                    String temp = itemList[j];
                    itemList[j] = itemList[j + 1];
                    itemList[j + 1] = temp;
                }

            }
        }
        for (int i = 0; i < this.itemCounter; i++) {
            recipt.append(itemList[i]);
        }


        double randomTaxPercent = 0.05 + (0.20 - 0.05) * random.nextDouble();
        double taxPercentage = randomTaxPercent * 100 ;
        this.tax = this.totalPrice * randomTaxPercent;
        this.total = this.totalPrice + this.tax;

        recipt.append("========================\n");
        recipt.append("SUBTOTAL   : ").append(df.format(this.totalPrice)).append("\n");
        recipt.append("TAX        : ").append(df.format(taxPercentage)).append("%").append("\n");
        recipt.append("GRAND TOTAL: ").append(df.format(this.tax)).append( " + ").append(df.format(this.totalPrice))
                .append(" = ").append(df.format(this.total)).append("\n");

        String finalOutput = recipt.toString();
        System.out.println("\n" + finalOutput);

        String encodedReceipt = Base64.getEncoder().encodeToString(finalOutput.getBytes());
        System.out.println("========= BASE64 ENCRYPTED RECEIPT =========");
        System.out.println(encodedReceipt);
        System.out.println("============================================");
    }

    private void reciptHeader() {
        recipt.append("========= RECIPT =========\n");
        recipt.append("Store: ").append(config.getProperty("storeName")).append("\n");
        recipt.append("Cashier: ").append(config.getProperty("cashierName")).append("\n");
        recipt.append("Receipt ID: ").append(reciptId.toString()).append("\n");
        recipt.append("--------------------------\n");
    }

    private void reciptBody() {
        while (true) {
            try {
                System.out.print("Enter Item Name : ");
                String name = input.nextLine().trim();

                Objects.requireNonNull(name, "Nama Tidak Boleh null!");
                if (name.isEmpty() || name.equals("")) {
                    throw new IllegalArgumentException("Nama Tidak Boleh kosong!");
                }

                System.out.print("Enter Quantity : ");
                String qtyInput = input.nextLine().trim();
                if (!qtyInput.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Quantity harus berupa angka bulat positif!");
                }
                this.quantity = Integer.parseInt(qtyInput);
                if (this.quantity < 1) {
                    throw new IllegalArgumentException("Jumlah Tidak Boleh Kurang dari 1");
                }

                System.out.print("Enter Price : ");
                String priceInput = input.nextLine().trim();
                if (!priceInput.matches("^[0-9]+(\\.[0-9]+)?$")) {
                    throw new IllegalArgumentException("Format harga salah! Harus angka bulat atau desimal.");
                }
                this.price = Double.parseDouble(priceInput);
                if (this.price < 1) {
                    throw new IllegalArgumentException("Hayo Berapa harganya? Harus di atas 0");
                }

                Double itemSubtotal = totalCalculation();
                this.totalPrice += itemSubtotal;

                System.out.println("----------------------------------------------------------------");
                System.out.println
                               (" Name     : "+name + "\n" +
                                " Quantity : "+ this.quantity + "\n"+
                                " Price    : " + df.format(this.price));
                System.out.println("----------------------------------------------------------------");

                StringBuilder itemDetails = new StringBuilder();
                itemDetails.append(name).append(" x ").append(this.quantity)
                        .append(" = ").append(df.format(itemSubtotal)).append("\n");

                itemList[this.itemCounter] = itemDetails.toString();

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }
    }

    private Double totalCalculation() {
        return this.quantity * this.price;
    }
}