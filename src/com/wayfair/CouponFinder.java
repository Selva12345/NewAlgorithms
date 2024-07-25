package com.wayfair;

import java.time.Instant;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CouponFinder {
    // HashMap to store all coupons for each category
    private static Map<String, List<Coupon>> categoryToCoupons = new HashMap<>();
    // HashMap to store the parent category for each category
    private static Map<String, String> categoryToParent = new HashMap<>();
    // HashMap to store all products by name
    private static Map<String, Product> products = new HashMap<>();

    // Coupon class to store coupon details
    static class Coupon {
        String couponName;
        Date dateModified;
        String discount;

        Coupon(String couponName, Date dateModified, String discount) {
            this.couponName = couponName;
            this.dateModified = dateModified;
            this.discount = discount;
        }
    }

    // Product class to store product details
    static class Product {
        String productName;
        double price;
        String categoryName;

        Product(String productName, double price, String categoryName) {
            this.productName = productName;
            this.price = price;
            this.categoryName = categoryName;
        }
    }

    static {
        // Populate category hierarchy
        categoryToParent.put("Comforter Sets", "Bedding");
        categoryToParent.put("Bedding", "Bed & Bath");
        categoryToParent.put("Bed & Bath", null);
        categoryToParent.put("Soap Dispensers", "Bathroom Accessories");
        categoryToParent.put("Bathroom Accessories", "Bed & Bath");
        categoryToParent.put("Toy Organizers", "Baby And Kids");
        categoryToParent.put("Baby And Kids", null);

        // Date format to parse DateModified
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Populate category to coupon mapping
            addCoupon("Comforter Sets", "Comforters Sale", sdf.parse("2020-01-01"), "10%");
            addCoupon("Comforter Sets", "Cozy Comforter Coupon", sdf.parse("2020-01-01"), "$15");
            addCoupon("Bedding", "Best Bedding Bargains", sdf.parse("2019-01-01"), "35%");
            addCoupon("Bedding", "Savings on Bedding", sdf.parse("2019-01-01"), "25%");
            addCoupon("Bed & Bath", "Low price for Bed & Bath", sdf.parse("2018-01-01"), "50%");
            addCoupon("Bed & Bath", "Bed & Bath extravaganza", sdf.parse("2019-01-01"), "75%");

            // Populate products
            addProduct("Cozy Comforter Sets", 100.00, "Comforter Sets");
            addProduct("All-in-one Bedding Set", 50.00, "Bedding");
            addProduct("Infinite Soap Dispenser", 500.00, "Bathroom Accessories");
            addProduct("Rainbow Toy Box", 257.00, "Baby And Kids");

            // Preprocess to ensure each category has its coupon
            for (String category : categoryToParent.keySet()) {
                findCoupon(category);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Function to add coupon to the map
    private static void addCoupon(String categoryName, String couponName, Date dateModified, String discount) {
        List<Coupon> coupons = categoryToCoupons.getOrDefault(categoryName, new ArrayList<>());
        coupons.add(new Coupon(couponName, dateModified, discount));
        categoryToCoupons.put(categoryName, coupons);
    }

    // Function to add product to the map
    private static void addProduct(String productName, double price, String categoryName) {
        products.put(productName, new Product(productName, price, categoryName));
    }

    // Function to find the current valid coupon for a given category
    public static String findCoupon(String categoryName) {
        Date currentDate = new Date();

        // Get the most recent valid coupon for the current date
        Coupon validCoupon = getMostRecentValidCoupon(categoryName, currentDate);

        if (validCoupon != null) {
            return validCoupon.couponName;
        } else {
            String parentCategory = categoryToParent.get(categoryName);
            while (parentCategory != null) {
                validCoupon = getMostRecentValidCoupon(parentCategory, currentDate);
                if (validCoupon != null) {
                    // Cache the result for future queries
                    categoryToCoupons.put(categoryName, categoryToCoupons.get(parentCategory));
                    return validCoupon.couponName;
                }
                parentCategory = categoryToParent.get(parentCategory);
            }
            return null;
        }
    }

    // Function to get the most recent valid coupon for a given category and date
    private static Coupon getMostRecentValidCoupon(String categoryName, Date currentDate) {
        List<Coupon> coupons = categoryToCoupons.get(categoryName);
        if (coupons == null) return null;

        Coupon mostRecentValidCoupon = null;
        for (Coupon coupon : coupons) {
            if (!coupon.dateModified.after(currentDate)) {
                if (mostRecentValidCoupon == null || coupon.dateModified.after(mostRecentValidCoupon.dateModified)) {
                    mostRecentValidCoupon = coupon;
                }
            }
        }
        return mostRecentValidCoupon;
    }

    // Function to calculate the discounted price for a given product
    public static String getDiscountedPrice(String productName) {
        Product product = products.get(productName);
        if (product == null) {
            return null;
        }

        String couponName = findCoupon(product.categoryName);
        if (couponName == null) {
            return String.format("%.2f", product.price);
        }

        Coupon coupon = getMostRecentValidCoupon(product.categoryName, new Date());
        if (coupon == null) {
            return String.format("%.2f", product.price);
        }

        double discountedPrice = applyDiscount(product.price, coupon.discount);
        return String.format("%.2f", discountedPrice);
    }

    // Function to apply discount to a price
    private static double applyDiscount(double price, String discount) {
        if (discount.endsWith("%")) {
            double percentage = Double.parseDouble(discount.replace("%", ""));
            return price - (price * percentage / 100);
        } else if (discount.startsWith("$")) {
            double amount = Double.parseDouble(discount.replace("$", ""));
            return price - amount;
        } else {
            return price;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice("Cozy Comforter Sets"));         // Output: 85.00 (or 90.00 depending on date)
        System.out.println(getDiscountedPrice("All-in-one Bedding Set"));      // Output: 32.50 (or 37.50 depending on date)
        System.out.println(getDiscountedPrice("Infinite Soap Dispenser"));     // Output: 125.00
        System.out.println(getDiscountedPrice("Rainbow Toy Box"));             // Output: 257.00
        Long val=Instant.now().toEpochMilli();
        Date date=new Date(val);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();

    }
}

